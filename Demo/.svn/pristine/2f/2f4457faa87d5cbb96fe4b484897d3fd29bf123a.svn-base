package cn.xs.main;

import java.io.IOException;

import cn.xs.api.EngineException;
import cn.xs.api.NativeMethod.Options;
import cn.xs.api.NativeMethod.VerifyResults;
import cn.xs.api.VBEngine;
import cn.xs.utils.AudioUtils;
import cn.xs.utils.LogUtils;

public class VerifyVoicePrint {
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
		
		// mod
		float[] readVoicePrint = AudioUtils.readVoicePrint("C:\\Zoo\\Verify.mod");
		
		
		// wav
		String path = "C:\\SeparationDemo\\Case2\\Verify.wav";
		byte[] readAudioData = AudioUtils.readAudioData(path);
		
		
/*		VerifyResults.ByReference result = new VerifyResults.ByReference();
		VerifyResults.ByReference result2 = new VerifyResults.ByReference();
		VerifyResults.ByReference result3 = new VerifyResults.ByReference();
		VerifyResults.ByReference result4 = new VerifyResults.ByReference();*/
		
		//float verifyVoicePrint = engine.VerifyVoicePrint(readVoicePrint, readVoicePrint2);
		VerifyResults.ByReference result1 = new VerifyResults.ByReference();
		
		try {
			engine.Verify(readAudioData, "pcm16", 8000, new Options(), readVoicePrint, result1);
			
			System.out.println("result --> "+result1.m_score);
			
			try {
				LogUtils.writeLog("C:\\SeparationDemo", path, result1.m_score);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
