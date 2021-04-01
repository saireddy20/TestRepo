package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Constants.constants;
import pages.BillingPage;
import pages.CartPage;
import pages.HomePage;
import pages.Login;
import pages.Logout;
import pages.OrderConfirmationpage;
import pages.ProductsListPage;
import pages.Registration;
import pages.ShoppingCartPage;
import utility.ScreenShot;

public class TestBase {
	protected WebDriver driver = null;
	protected Registration registration = null;
	protected Login login = null;
	protected HomePage homepage = null;
	protected ProductsListPage productlist = null;
	protected CartPage cartpage = null;
	protected ShoppingCartPage shopping = null;
	protected BillingPage billing = null;
	protected OrderConfirmationpage confirm = null;
	protected Logout logout=null;

	protected ScreenShot screenshot = null;

	protected Properties data = null;

	public TestBase() {
		data = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("..\\MadisionIslandSite\\src\\main\\resources\\data.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeSuite()
	@Parameters("browser")
	public void start(String browser) {

		this.driver = BrowserFactory.getWebDriver(browser);
		this.driver.get(constants.URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(constants.SECONDS, TimeUnit.SECONDS);

	}

	@BeforeClass
	public void browserSetup() {
		registration = new Registration(this.driver);
		login = new Login(driver);
		homepage = new HomePage(driver);
		productlist = new ProductsListPage(driver);
		cartpage = new CartPage(driver);
		shopping = new ShoppingCartPage(driver);
		billing = new BillingPage(driver);
		confirm = new OrderConfirmationpage(driver);
		logout =new Logout(driver);

	}

	public WebDriver getDriver() {
		return this.driver;
	}

	@AfterMethod
	public void takescreenshot(ITestResult result) throws IOException, InterruptedException {

		if (ITestResult.SUCCESS == result.getStatus()) {
			logout.Logoutclick();
		}

	}

}
