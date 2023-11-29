package SCMflex;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com_ObjectRepo.AdminProductspage;
import com_ObjectRepo.Adminhomepage;
import com_ObjectRepo.LoginPage;
import com_ObjectRepo.Managestockpage;
import com_ObjectRepo.ManufacturerAddProductspage;
import com_ObjectRepo.ManufacturerHomepage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtilities;
import genericUtilities.PropertyFileUtilities;
import genericUtilities.WebDriverUtilies;
@Test(groups = "Systemtest")
public class Manufacturer_should_be_able_to_update_stock_and_Admin_can_see_Update_Stock extends BaseClass{
	@Test
	public  void Manufacturer_should_be_able_to_update_stock() throws Throwable {
		// PropertyFileUtilities plib=new PropertyFileUtilities();
		//  ExcelUtilities elib= new ExcelUtilities();
		// WebDriverUtilies wlib=new WebDriverUtilies();
		// Read data from properties file

		//String BROWSER =plib.readDataFromPropertyFile("browser");
		
		//String URL = plib.readDataFromPropertyFile("url");
		Adminhomepage Ahome=new Adminhomepage(driver);
		Ahome.getLogout().click();
		String USERNAME = plib.readDataFromPropertyFile("manufacturerusername");
		String PASSWORD =plib.readDataFromPropertyFile("manufacturerpassword");
		String ManufacturerLOGINTYPE = plib.readDataFromPropertyFile("Manufacturerlogintype");
		String AdminLOGINTYPE = plib.readDataFromPropertyFile("adminlogintype");
		String AdminUsername = plib.readDataFromPropertyFile("adminusername");
		String Adminpassword = plib.readDataFromPropertyFile("adminpassword");

		//WebDriver driver = new ChromeDriver();
		//wlib.maximizeWindow(driver);
		//wlib.waitForPageload(driver, 20);
		//driver.get(URL);
		Thread.sleep(4000);
		LoginPage login=new LoginPage(driver);
		login.loginTOApplication(USERNAME, PASSWORD, ManufacturerLOGINTYPE);


		String actualtitle = driver.getTitle();
		String expectedtitle = "Manufacturer: Home";
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("Manufacturer Homepage is displayed... and its verified with title");

		//		if (actualtitle.equals(expectedtitle)) {
		//			System.out.println("Manufacturer Homepage is displayed... and its verified with title");
		//		} else {
		//			System.out.println("Manufacturer Homepage is Not displayed...");
		//		}

		// add products
		// Click On add product Link
		ManufacturerHomepage Mhome=new ManufacturerHomepage(driver);
		Mhome.getaddproductslink().click();
		String actualaddproducttitle = driver.getTitle();
		String expectedproductpagetitle = "Add Product";
		Assert.assertEquals(actualaddproducttitle, expectedproductpagetitle);
		System.out.println("addProduct page is displayed... and its verified with title");
		//		if (actualaddproducttitle.equals(expectedproductpagetitle)) {
		//			System.out.println("addProduct page is displayed... and its verified with title");
		//		} else {
		//			System.out.println("addProduct page is Not displayed...");
		//		}

		ManufacturerAddProductspage Maddp=new ManufacturerAddProductspage(driver);

		Maddp.getStockmanagementcheckbox().click();

		// Dropdown
		String unitType = elib.readDataFromExcel("Sheet1", 0,4);
		String category =elib.readDataFromExcel("Sheet1", 1,4);

		// Enter data in description
		String desc =elib.readDataFromExcel("Sheet1", 0,7);


		Maddp.Manufacturerabletoaddproduct(elib.readDataFromExcel("Sheet1", 0,1), elib.readDataFromExcel("Sheet1", 1, 1), unitType, category, desc);

		// Handle alert and print the text
		wlib.gettextfromalert(driver);
		wlib.acceptalert(driver);

		// click on manage stock link
		Mhome.getManagestocklink().click();
		// click on chips quantity
		Managestockpage manstock=new Managestockpage(driver);
		WebElement quantity=manstock.getQuantity();	
		quantity.click();
		quantity.clear();
		quantity.sendKeys("70");
		// click on update button
		manstock.getUpdatestock().click();

		// Handle the confirmation popup
		wlib.gettextfromalert(driver);
		wlib.acceptalert(driver);

		// click on logout as a manufacturer
		// Click on logout button
		manstock.getlogout().click();



		Thread.sleep(5000);
		// Verify login page should be displayed
		String actualloginpageTitle = driver.getTitle();

		String ExpectedLoginpageTitle1 = "Login";

		Assert.assertEquals(actualloginpageTitle, ExpectedLoginpageTitle1);
		System.out.println("Login page is displayed and its verified with title");
		//		if (actualloginpageTitle.contains(ExpectedLoginpageTitle1)) 
		//		{
		//			System.out.println("Login page is displayed and its verified with title");
		//		} else 
		//		{
		//			System.out.println("Login page is not displayed");
		//		}

		login.loginTOApplication(AdminUsername, Adminpassword,AdminLOGINTYPE);

		String actualtitle1 = driver.getTitle();
		String expectedtitle1 = "Admin: Home";
		Assert.assertEquals(actualtitle1,expectedtitle1);
		System.out.println("Admin Homepage is displayed... and its verified with title");
		//		if (actualtitle1.equals(expectedtitle1)) {
		//			System.out.println("Admin Homepage is displayed... and its verified with title");
		//		} else {
		//			System.out.println("Admin Homepage is Not displayed...");
		//		}

		// click on product link


		Ahome.getProductslink().click();


		AdminProductspage Aprdpage=new AdminProductspage(driver);
		Aprdpage.UpdateProductNameAlongWithprice(driver);

	}
}

