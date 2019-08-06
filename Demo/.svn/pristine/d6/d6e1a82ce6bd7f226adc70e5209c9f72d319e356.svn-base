package cn.xs.utils;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyUtils {
	public static void saveMixAudio(String path, byte[] audioMixAudio){
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new FileOutputStream(path,true));

			for (byte b : audioMixAudio) {
				//out.writeFloat(f);
				out.writeByte(b);
				out.flush();

			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();

				}
			}
		}
	}
}
