package cn.xs.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.AbstractDocument.BranchElement;

public class LogUtils {

	public static void writeLog(String path, String fileName, float score) throws IOException{
		
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append(path).append("\\Log.txt");
		
		File file = new File(stringBuffer.toString());
		if(!file.exists()){
			file.createNewFile();
		}
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
		
		bufferedWriter.write("音频名称为： "+ fileName +", 得分为： "+ score);
		bufferedWriter.newLine();
		
		bufferedWriter.flush();
		bufferedWriter.close();
		
		
	}
}
