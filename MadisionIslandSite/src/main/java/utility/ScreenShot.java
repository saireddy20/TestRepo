package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	public static String screenShot(WebDriver driver, String path,String methodname) throws IOException, InterruptedException {
		String screenshotpath = path +"\\"+methodname+UtilClass.getCurrentTime();
		File name=new File(screenshotpath);
		name.mkdir();
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File s = new File(screenshotpath+"\\"+methodname+".jpg");
		FileHandler.copy(file, s);
		return screenshotpath;
	}
}
