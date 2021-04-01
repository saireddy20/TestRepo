package TestPages;

import org.testng.annotations.Test;

import Constants.constants;

import org.testng.Assert;
import java.io.IOException;
import java.util.Map;

import base.TestBase;

import pages.Registration;
import utility.ScreenShot;

public class TestRegistration extends TestBase {
	
	@Test(dataProviderClass = utility.Data_Provider.class, dataProvider = "Madison")
	public void Valid_And_Invalid_Registration(Map<String, String> mapData) throws IOException, InterruptedException {

		
		registration.Registration_To_Page(mapData.get("firstname"), mapData.get("middlename"), mapData.get("lastname"),
				mapData.get("emailid"), mapData.get("password"), mapData.get("confirmpassword"));
		registration.assertcheckBy();
		Assert.assertEquals(registration.assertcheckBy(), "Thank you for registering with Madison Island.");
 
	}
	
}
