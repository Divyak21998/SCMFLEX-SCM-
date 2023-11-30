package SCMflex;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

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

import com_ObjectRepo.Adminhomepage;
import com_ObjectRepo.LoginPage;
import com_ObjectRepo.ManufacturerAddProductspage;
import com_ObjectRepo.ManufacturerHomepage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtilities;
import genericUtilities.PropertyFileUtilities;
import genericUtilities.WebDriverUtilies;

public class Manufacturer_should_be_able_to_add_products_Test extends BaseClass 
{
	@Test(groups = "Systemtest")
	public  void Manufacturer_should_be_able_to_add_products()throws Throwable {
		PropertyFileUtilities pfiles=new PropertyFileUtilities();
		//		WebDriverUtilies wlib=new WebDriverUtilies();
		//		ExcelUtilities elib=new ExcelUtilities();
		//		String BROWSER = pfiles.readDataFromPropertyFile("browser");
		//String URL = pfiles.readDataFromPropertyFile("url");
		Adminhomepage Ahome=new Adminhomepage(driver);
		Ahome.getLogout().click();
		String USERNAME = pfiles.readDataFromPropertyFile("manufacturerusername");
		String PASSWORD = pfiles.readDataFromPropertyFile("manufacturerpassword");
		String ManufacturerLOGINTYPE = pfiles.readDataFromPropertyFile("Manufacturerlogintype");


		//		WebDriver driver = new ChromeDriver();
		//
		//		wlib.maximizeWindow(driver);
		//		wlib.waitForPageload(driver, 20);
		//		driver.get(URL);
		Thread.sleep(3000);
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
		// Excel Utility
		ManufacturerAddProductspage Maddp=new ManufacturerAddProductspage(driver);
		driver.findElement(By.xpath("//input[@value='1']")).click();
		// Dropdown
		String unitType = elib.readDataFromExcel("Sheet1", 0,4);
		String category =elib.readDataFromExcel("Sheet1", 1,4);
		// Enter data in description
		String desc =elib.readDataFromExcel("Sheet1", 0,7);
		Maddp.Manufacturerabletoaddproduct(elib.readDataFromExcel("Sheet1", 0,1), elib.readDataFromExcel("Sheet1", 1, 1), unitType, category, desc);
		// Handle alert and print the text
		wlib.gettextfromalert(driver);
		wlib.acceptalert(driver);

	}

}
