package com.Banking_Project.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;  //Created an object for the properties 
	
	public ReadConfig()  //Created a constructor to load the complete file
	{
		File src = new File("./Configuation\\config.properties");  // ./ represents the project home directory
		
		//Used the try and catch statement just if the file is not available in its location then will capture the error.
		try {
			FileInputStream fis = new FileInputStream(src);  //Load the file data/import the file data so that it will readable 
			pro = new Properties();
			pro.load(fis);  //Read the file
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}		
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");  //.getproperty() method helps to capture the value from the properties file.
		return url;
	}
	
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFireFoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

}
