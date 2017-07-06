package com.st.base;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class SelHelloWorld {
	public static Properties Param = null;
	public static WebDriver driver=null;
	public static void main(String args[]) throws IOException
	   {
	         
	      
	    //Initialize Param.properties file.
		Param = new Properties();
		FileInputStream fip = new FileInputStream("C:/AutmationProjects/Selenium/SHW/src/com/st/property/Param.properties");
		Param.load(fip);
	    
		System.out.println(Param.getProperty("siteURL"));
		System.out.println(Param.getProperty("testBrowser"));
		System.out.println("Test the build after adding this line, to verify jenkins");
		loadWebBrowser(); 
	   }
	
	public static void loadWebBrowser(){	
		
		
			if(Param.getProperty("testBrowser").equalsIgnoreCase("Mozilla")){
				//To Load Firefox driver Instance. 
				driver = new FirefoxDriver();				
				
				
			}else if(Param.getProperty("testBrowser").equalsIgnoreCase("Chrome")){				
				//To Load Chrome driver Instance.
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDrivers//chromedriver.exe");
				driver = new ChromeDriver();
				
			}else if(Param.getProperty("testBrowser").equalsIgnoreCase("IE")){				
				driver = new InternetExplorerDriver();			
				
			}
			driver.get(Param.getProperty("siteURL"));
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("id('lst-ib')")).sendKeys("https://assurancetech.wordpress.com");
			//driver.send selenium.keyDown(id, "\\13");
			driver.findElement(By.xpath("id('lst-ib')")).sendKeys(Keys.RETURN);
			
			
	}
}
