package cn.xs.utils;

public class GetOneNameOnAllPath {
	public String lastName(String allPath){
		
		String realPath = allPath.substring(allPath.lastIndexOf("\\") + 1,
				allPath.lastIndexOf("."));
		
		return realPath;
		
	}
}
