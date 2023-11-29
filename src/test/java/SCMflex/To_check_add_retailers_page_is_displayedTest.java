package SCMflex;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com_ObjectRepo.Adminhomepage;
import com_ObjectRepo.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.DatabaseUtilities;
import genericUtilities.ExcelUtilities;
import genericUtilities.JavaUtilities;
import genericUtilities.PropertyFileUtilities;
import genericUtilities.WebDriverUtilies;

public class To_check_add_retailers_page_is_displayedTest extends BaseClass
{
	@Test(groups ="Smoketest")
	public void To_check_add_retailers_page_is_displayed() throws InterruptedException, Throwable 
	{
		//creating object for generic utilities package
		//				PropertyFileUtilities flib=new PropertyFileUtilities();
		//				WebDriverUtilies wlib=new WebDriverUtilies();
		//		//lanching browser
		//		WebDriver driver=new ChromeDriver();
		//		//maximize window
		//		wlib.maximizeWindow(driver);
		//		wlib.waitForPageload(driver, 20);

		//Fetching data from property file
		//				String BROWSER=flib.readDataFromPropertyFile("browser");
		//				String URL=flib.readDataFromPropertyFile("url");
		//				String username=flib.readDataFromPropertyFile("adminusername");
		//				String password=flib.readDataFromPropertyFile("adminpassword");
		//				
		//login to application
		//		driver.get(URL);
		//		LoginPage login=new LoginPage(driver);
		//		login.loginTOApplication(username, password, "Admin");

		String actualtitle = driver.getTitle();
		String expectedtitle = "Admin: Home";

		if (actualtitle.equals(expectedtitle)) 
		{
			System.out.println("home page is displayed...verified with tittle");

		}
		else
		{
			System.out.println("home page is not displayed...");
		}
		Adminhomepage Ahome=new Adminhomepage(driver);
		Ahome.getAddretailerslink().click();
		String actualaddretailerpagetitle = driver.getTitle();
		String expectedaddretailerpagedetail ="Add Retailer";
		Assert.assertEquals(actualaddretailerpagetitle, expectedaddretailerpagedetail);
		System.out.println("Add retailer page is  displayed..");

//		if (actualaddretailerpagetitle.equalsIgnoreCase(expectedaddretailerpagedetail)) 
//		{
//			System.out.println("Add retailer page is displayed..verified with title");
//
//		}
//		else
//		{
//			System.out.println("Add retailer page is not displayed..");
//		}


	}

}

