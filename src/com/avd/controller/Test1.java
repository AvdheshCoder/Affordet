package com.avd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

public class Test1 {	
	
	public static void main(String[] arg)
	{
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");   	
	        System.out.println(sdf.format(new Date()));
		
	}

}
