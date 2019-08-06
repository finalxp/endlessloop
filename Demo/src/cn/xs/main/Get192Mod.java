package cn.xs.main;

import cn.xs.api.EngineException;
import cn.xs.api.NativeMethod.EnrolResults;
import cn.xs.api.NativeMethod.Options;
import cn.xs.api.VBEngine;
import cn.xs.utils.AudioUtils;

public class Get192Mod {
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
		
		
		
		byte[] readAudioData = AudioUtils.readAudioData("C:\\SeparationDemo\\Case2\\Verify.wav");
		
		Options options = new Options();
		//options.
		
		EnrolResults.ByReference result = new EnrolResults.ByReference();
		
		try {
			float[] enrol = engine.Enrol(readAudioData, "pcm16", 8000, options, result);
			
			AudioUtils.saveVoicePrint("C:\\mod", enrol);
			
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
