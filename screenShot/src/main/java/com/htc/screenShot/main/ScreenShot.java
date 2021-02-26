package com.htc.screenShot.main;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ScreenShot {
	 WebDriver chromeDriver=null;

		@BeforeMethod
		public void setup() {
	       System.setProperty("webdriver.chrome.driver","C:\\Users\\saiprasad\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		}

		@AfterMethod
		public void tearDown() {
			
		}

	    @Test
		public void testSearchBox_screenShot() throws IOException {
	    	//DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyyHH:mm:ss");
	    	//Date date = new Date();
	    	//String date1= dateFormat.format(date);
			String picturename="screenshot";
		    WebDriver chromeDriver=new ChromeDriver();
			chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			chromeDriver.get("http://demo-store.seleniumacademy.com/");
			WebElement serachbox=chromeDriver.findElement(By.xpath("//input[@id=\"search\"]"));
			serachbox.sendKeys("free");
			
			File file=((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
			File path=new File("C:\\Users\\saiprasad\\eclipse-testingworkspace\\screenShot\\src\\test\\resources\\"+picturename+timestamp()+".jpg");
			Files.copy(file,path);
			//Files.copy(file,new File("E:\\"+picturename+timestamp()+".jpg"));


			
		}
	    public String timestamp() {
	         return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	 }
		
}