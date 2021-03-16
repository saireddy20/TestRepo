package reports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import Constants.constants;
import base.TestBase;
import utility.ScreenShot;

public class Listeners extends TestBase implements ITestListener {
	WebDriver driver;
	ScreenShot screenshot = new ScreenShot();
	ExtentManager extentmanager=new ExtentManager();

	public void onTestStart(ITestResult result) {
		System.out.println("***TEST IS STARTED***");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("***TEST IS PASSED SUCCESSFULLY***");
		/*
		 * try { ScreenShot.screenShot(driver, constants.SCREENSHOT_PASS); } catch
		 * (IOException | InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } if (result.getStatus() == ITestResult.SUCCESS) {
		 * ExtentManager.test = ExtentManager.extent.createTest(result.getName());
		 * ExtentManager.test.log(Status.PASS, "Pass Test case is: " +
		 * result.getName()); try { ScreenShot.screenShot(driver,
		 * constants.SCREENSHOT_PASS); } catch (IOException | InterruptedException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } }
		 */
		 
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***TEST IS FAILED***");
		/*
		 * if (result.getStatus() == ITestResult.FAILURE) {
		 * 
		 * ExtentManager.test =
		 * ExtentManager.extent.createTest(result.getMethod().getMethodName());
		 * ExtentManager.test.log(Status.FAIL, "Failed Test case is: " +
		 * result.getMethod().getMethodName()); try { ScreenShot.screenShot(driver,
		 * constants.SCREENSHOT_FAIL); } catch (IOException | InterruptedException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } }
		 */
		try {
			Throwable message=result.getThrowable();
		}catch (Throwable message) {
			System.out.println(result.getThrowable().fillInStackTrace().getMessage());
			throw message;
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("***TEST IS SKIPPED***");
		/*
		 * if (result.getStatus() == ITestResult.SKIP) { ExtentManager.test =
		 * ExtentManager.extent.createTest(result.getName());
		 * ExtentManager.test.log(Status.SKIP, "Skipped Test case is: " +
		 * result.getName()); }
		 */

	}

}
