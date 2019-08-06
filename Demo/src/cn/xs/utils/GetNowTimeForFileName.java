package cn.xs.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowTimeForFileName {
	public static String GetTimeName(String FileName, String FilePath) {

		Date date = new Date();

		DateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");

		String timeNow = format.format(date);

		StringBuffer sBuffer = new StringBuffer();
		
		sBuffer.append(FilePath).append("\\").append(timeNow).append(FileName).append(".wav");
		
		String FinalName = sBuffer.toString();
		
		return FinalName;

	}
}
