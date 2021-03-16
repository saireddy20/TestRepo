package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Constants.constants;
import utility.UtilClass;

public class ExtentManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(
				constants.EXTENTREPORT_PATH + "\\Report" + UtilClass.getCurrentTime() + ".html");

		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("Ecommerce Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "EcommerceTest");
		extent.setSystemInfo("Tester", "sai");
		extent.setSystemInfo("OS", "Win8");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public void endReport() {
		extent.flush();
	}
}
