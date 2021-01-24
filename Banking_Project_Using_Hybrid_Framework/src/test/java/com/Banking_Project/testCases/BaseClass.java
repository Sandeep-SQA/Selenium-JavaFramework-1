package com.Banking_Project.testCases;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.Banking_Project.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();  //Created an object for the ReadConfig class
	 
	public String baseURL = readconfig.getApplicationURL();  //Called the URL from ReadConfig class
	public String username = readconfig.getUsername();       //Called the Username from ReadConfig class
	public String password = readconfig.getPassword();       //Called the Password from ReadConfig class
	public static WebDriver driver;
	
	public static Logger logger;
	public static SimpleDateFormat df;
		
	@Parameters("browser") //@Parameter() annotation used to tell which browser need to invoke.
	@BeforeClass
	public void setup(String br)
	{
		//If else Statement used to tell the system that which browser need to be selected
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());  //Called the ChromePath from ReadConfig class
		//System.getProperty("user.dir") == this method will give the project path/directory      
		driver = new ChromeDriver();
		}
		
		else if(br.equals("firefox")) {
		System.setProperty(("webdriver.gecko.driver"),	readconfig.getFireFoxPath());
		driver = new FirefoxDriver();
		}	
		
		//This is an Simple date format which is going to be used by log4j log naming conversion
        df = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	    System.setProperty("current.date.time", df.format(new Date()));
				
		//Adding the Log4j methods
		logger = Logger.getLogger("Banking_APP");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get(baseURL);
		logger.info("URL is opened");
		}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
