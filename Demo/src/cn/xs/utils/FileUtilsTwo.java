package cn.xs.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtilsTwo {

	public static List<String> getFiles(String path, boolean includeSubPath) {
		List<String> fileList = new ArrayList<>();
		listFiles(path,fileList,includeSubPath);
		return fileList;
	}
	
	public static List<String> getFiles(String Path) {
		return getFiles(Path, false);
	}
	
	private static void listFiles(String path, List<String> fileList, boolean includeSubPath){
		File file = new File(path);
		if(!file.isDirectory()){
			fileList.add(path);
			return;
		}
		
		File[] files = file.listFiles();
		if(files.length == 0)
			return;
		
		for(File f : files) {
			if(!f.isDirectory()){
				fileList.add(f.getAbsolutePath());
			}else {
				if (includeSubPath) {
					listFiles(f.getAbsolutePath(), fileList, includeSubPath);
				}
			}
		}	
	}	
}
