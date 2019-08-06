package cn.xs.main;



import javax.rmi.CORBA.Util;

import cn.xs.api.EngineException;
import cn.xs.api.NativeMethod.Options;
import cn.xs.api.NativeMethod.VerifyResults;
import cn.xs.api.VBEngine;
import cn.xs.utils.AudioUtils;
import cn.xs.utils.MyUtils;

public class AudioSeparation {
	public static void main(String[] args) {
		VBEngine engine = new VBEngine();
		System.out.print("Init Mode ti_plp2covv2\n");
		System.out.println("wait...");
		try {
			engine.Init("C:\\VBSDK\\", "ti_plp2covv2");
			System.out.print("Init Mode ti_plp2covv2 Success!\n");
		} catch (EngineException e) {
			e.printStackTrace();
			return;
		}
		
		byte[] audio = AudioUtils.readAudioData("C:\\telcom-pcm16\\audio00049.wav");
		
		
		double s = 1;
		int lengthAudio = (int) (20000 * s);
		int number = (audio.length / lengthAudio);
		System.out.println("number --> "+number);
		
		int lengthNoBoom = (audio.length/number)/2;
		int lastLength = lengthNoBoom * 2;
		
		for (int i = 0; i < number; i++) {
			
			byte[][] audioLast = new byte[number][];
			
			byte[] audioMid = new byte[lastLength];
			
			for (int j = 0; j < lastLength; j++) {
				
				audioMid[j] = audio[i*(lastLength)+j];
				
				//get audio db value
				//System.out.println(audioMid[j]);
							
			}
			
			audioLast[i] = audioMid;
			
			float[] readVoicePrint = AudioUtils.readVoicePrint("C:\\Mod2\\audio00049_2.mod");
			
			VerifyResults.ByReference result = new VerifyResults.ByReference();
			
			try {
				engine.Verify(audioLast[i], "pcm16", 8000, new Options(), readVoicePrint, result);
				
				System.out.println("result --> "+result.m_score);
				
			} catch (EngineException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if (result.m_score < -2) {
				
				
				MyUtils.saveMixAudio("C:\\SeparationDemo\\Case10\\SeparationAudio.wav", audioLast[i]);
				
				
			}
			
			
			
/*			float rms1 = rms(audioLast[i], 0, 1000);
			float rms2 = rms(audioLast[i], 44, 16000);
			float rms3 = rms(audioLast[i], 0, 8000);
			float rms4 = rms(audioLast[i], 44, 8000);
			float rms5 = rms(audioLast[i], 0, 4000);
			float rms6 = rms(audioLast[i], 44, 4000);
			
			System.out.println("rms1  --->  "+rms1);
			System.out.println("rms2  --->  "+rms2);
			System.out.println("rms3  --->  "+rms3);
			System.out.println("rms4  --->  "+rms4);
			System.out.println("rms5  --->  "+rms5);
			System.out.println("rms6  --->  "+rms6);
			
			float rmsdB1 = getRmsdB(rms1);
			float rmsdB2 = getRmsdB(rms2);
			float rmsdB3 = getRmsdB(rms3);
			float rmsdB4 = getRmsdB(rms4);
			float rmsdB5 = getRmsdB(rms5);
			float rmsdB6 = getRmsdB(rms6);
			
			System.out.println("rmsdB1 ---> "+rmsdB1);
			System.out.println("rmsdB2 ---> "+rmsdB2);
			System.out.println("rmsdB3 ---> "+rmsdB3);
			System.out.println("rmsdB4 ---> "+rmsdB4);
			System.out.println("rmsdB5 ---> "+rmsdB5);
			System.out.println("rmsdB6 ---> "+rmsdB6);
			
			
			System.out.println("--------");*/
		}
		
		//   vad
		
		/*float rms1 = rms(audio, 0, 16000);
		float rms2 = rms(audio, 44, 16000);
		float rms3 = rms(audio, 0, 8000);
		float rms4 = rms(audio, 44, 8000);
		float rms5 = rms(audio, 0, 4000);
		float rms6 = rms(audio, 44, 4000);
		
		System.out.println("rms1  --->  "+rms1);
		System.out.println("rms2  --->  "+rms2);
		System.out.println("rms3  --->  "+rms3);
		System.out.println("rms4  --->  "+rms4);
		System.out.println("rms5  --->  "+rms5);
		System.out.println("rms6  --->  "+rms6);
		
		float rmsdB1 = getRmsdB(rms1);
		float rmsdB2 = getRmsdB(rms2);
		float rmsdB3 = getRmsdB(rms3);
		float rmsdB4 = getRmsdB(rms4);
		float rmsdB5 = getRmsdB(rms5);
		float rmsdB6 = getRmsdB(rms6);
		
		System.out.println("rmsdB1 ---> "+rmsdB1);
		System.out.println("rmsdB2 ---> "+rmsdB2);
		System.out.println("rmsdB3 ---> "+rmsdB3);
		System.out.println("rmsdB4 ---> "+rmsdB4);
		System.out.println("rmsdB5 ---> "+rmsdB5);
		System.out.println("rmsdB6 ---> "+rmsdB6);*/
	}
	
	private static float getRmsdB(float rms) {
		
		//add by me
		float mNoiseLevel = 3; 
		
		if(mNoiseLevel < rms) {
			mNoiseLevel = (0.999f * mNoiseLevel) + (0.001f * rms);
		} else {
			mNoiseLevel = (0.95f * mNoiseLevel) + (0.05f * rms);
		}
		if(((double) mNoiseLevel) <= 0.0d || ((double) (rms / mNoiseLevel)) <= 1.0E-6d) {
			return -120.0f;
		}
		float orignalDb = 10.0f * ((float) Math.log10((double) (rms / mNoiseLevel)));
		//Clamp db to [0, 60]
		return Math.min(Math.max(0.0f, orignalDb), 60.0f);
	}
	
	private static float rms(byte[] buffer, int offset, int length){
		float sum = 0.0f;
		if(length == 0){
			throw new IllegalArgumentException();
		}
		for (int i = offset; i < offset+length; i += 2) {
			short sample = (short)0;
			for (int j = 0; j < 2; j++) {
				sample = (short) (((buffer[i+j] & 255) << (j * 8)) | sample);
				
			}
			sum += (float) (sample * sample);
		}
		
		float fff = (float)Math.sqrt((double) (sum / ((float) (length / 2))));
		return fff;
	}
	
}
