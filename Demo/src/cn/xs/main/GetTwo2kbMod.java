package cn.xs.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.sun.jna.platform.FileUtils;

import cn.xs.api.EngineException;
import cn.xs.api.NativeMethod;
import cn.xs.api.NativeMethod.EnrolResults.ByReference;
import cn.xs.api.NativeMethod.Options;
import cn.xs.api.VBEngine;
import cn.xs.utils.AudioUtils;
import cn.xs.utils.FileUtilsTwo;

public class GetTwo2kbMod {
	
	
	
	public static void main(String[] args) {
		VBEngine engine = new VBEngine();
		System.out.print("Init Mode ti_plp2covv2\n");
		System.out.println("wait...");
		try {
			engine.Init("D:\\Work\\SDK\\VBSDK\\", "ti_plp2covv2");
			System.out.print("Init Mode ti_plp2covv2 Success!\n");
		} catch (EngineException e) {
			e.printStackTrace();
			return;
		}

		//File file = new File("C:\\telcom-pcm16");
		
		List<String> files = FileUtilsTwo.getFiles("D:\\Zoo\\Test730");
		
		for (String stringFileName : files) {
			System.out.println(stringFileName);
						
			
			String realPath = null;
			realPath = stringFileName.substring(stringFileName.lastIndexOf("\\") + 1,
					stringFileName.lastIndexOf("."));
			
			StringBuffer stringBuffer = new StringBuffer("D:\\Zoo\\ModBySeparation");
			StringBuffer stringBuffer2 = new StringBuffer(realPath);

			stringBuffer.append("\\").append(stringBuffer2).append(".mod");
			String finalPath = stringBuffer.toString();
			
			StringBuffer stringBuffer3 = new StringBuffer("D:\\Zoo\\ModBySeparation");
			StringBuffer stringBuffer4 = new StringBuffer(realPath);
			
			stringBuffer3.append("\\").append(stringBuffer4).append("_2").append(".mod");
			String finalPath2 = stringBuffer3.toString();
			
			
			
			byte[] data = AudioUtils
					.readAudioData(stringFileName);
			
			try {
				
				float[][] voicePrints = engine.separationAudio(data, "pcm16", 8000,
						new Options());
				
				//NativeMethod.EnrolResults.ByReference result = new NativeMethod.EnrolResults.ByReference();
					
				//float score = engine.VerifyVoicePrint(voicePrints[0],
				//		voicePrints[1]);
				
				
				AudioUtils.saveVoicePrint(finalPath, voicePrints[0]);
				AudioUtils.saveVoicePrint(finalPath2, voicePrints[1]);
				
				
			} catch (EngineException e) {
				e.printStackTrace();
			}
			
			
		}		
		
		engine.Reset();
	}
}
