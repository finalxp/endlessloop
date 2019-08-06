package cn.xs.main;

import cn.xs.api.EngineException;
import cn.xs.api.VBEngine;
import cn.xs.utils.AudioUtils;

public class NtoNorNtoMVerify {
	public static void main(String[] args) {
		VBEngine vbEngine = new VBEngine();
		
		try {
			vbEngine.Init("C:\\VBSDK\\", "ti_plp2covv2");
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AudioUtils.readVoicePrint("");
		
		//vbEngine.VerifyNToOneWithAudioData(audioData, audioSizes, format, sampleRate, voicePrint)
	}
}
