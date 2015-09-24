package com.sk.tools;

public class Tool {
	public static String getNewString(String input){
		String result="";
		try {
			result=new String(input.getBytes("ISO-8859-1"),"utf-8");
		} catch (Exception e) {
			// TODO: handle exceptioe
			e.printStackTrace();
		}
		return result;
	}

}
