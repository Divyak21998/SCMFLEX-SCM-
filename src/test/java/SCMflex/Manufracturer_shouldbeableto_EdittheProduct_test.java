package SCMflex;

import org.testng.Assert;
import org.testng.annotations.Test;

import com_ObjectRepo.AdminProductspage;
import com_ObjectRepo.Adminhomepage;
import com_ObjectRepo.EditProductPage;
import com_ObjectRepo.LoginPage;
import com_ObjectRepo.ManufacturerAddProductspage;
import com_ObjectRepo.ManufacturerHomepage;
import com_ObjectRepo.ManufacturerProductspage;
import genericUtilities.BaseClass;

public class Manufracturer_shouldbeableto_EdittheProduct_test extends BaseClass{
	@Test
	public void Manufracturer_shouldbeableto_EdittheProduct() throws Throwable {
	Adminhomepage Ahome=new Adminhomepage(driver);
	Ahome.getLogout().click();
	String USERNAME = plib.readDataFromPropertyFile("manufacturerusername");
	String PASSWORD =plib.readDataFromPropertyFile("manufacturerpassword");
	String ManufacturerLOGINTYPE = plib.readDataFromPropertyFile("Manufacturerlogintype");
	String AdminLOGINTYPE = plib.readDataFromPropertyFile("adminlogintype");
	String AdminUsername = plib.readDataFromPropertyFile("adminusername");
	String Adminpassword = plib.readDataFromPropertyFile("adminpassword");
	Thread.sleep(4000);
	LoginPage login=new LoginPage(driver);
	login.loginTOApplication(USERNAME, PASSWORD, ManufacturerLOGINTYPE);


	String actualtitle = driver.getTitle();
	String expectedtitle = "Manufacturer: Home";
	Assert.assertEquals(actualtitle, expectedtitle);
	System.out.println("Manufacturer Homepage is displayed... and its verified with title");
	ManufacturerHomepage Mhome=new ManufacturerHomepage(driver);
	Mhome.getaddproductslink().click();
	String actualaddproducttitle = driver.getTitle();
	String expectedproductpagetitle = "Add Product";
	Assert.assertEquals(actualaddproducttitle, expectedproductpagetitle);
	System.out.println("addProduct page is displayed... and its verified with title");
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
			Mhome.getProductslink().click();
			ManufacturerProductspage mfp=new ManufacturerProductspage(driver);
			mfp.getEdit().click();
			EditProductPage editprd=new EditProductPage(driver);
			editprd.Editproduct();
			wlib.gettextfromalert(driver);
			wlib.acceptalert(driver);
			editprd.getLogoutbutton().click();
			Thread.sleep(5000);
			// Verify login page should be displayed
			String actualloginpageTitle = driver.getTitle();

			String ExpectedLoginpageTitle1 = "Login";

			Assert.assertEquals(actualloginpageTitle, ExpectedLoginpageTitle1);
			System.out.println("Login page is displayed and its verified with title");
			login.loginTOApplication(AdminUsername, Adminpassword,AdminLOGINTYPE);

			String actualtitle1 = driver.getTitle();
			String expectedtitle1 = "Admin: Home";
			Assert.assertEquals(actualtitle1,expectedtitle1);
			System.out.println("Admin Homepage is displayed... and its verified with title");
			Ahome.getProductslink().click();
			AdminProductspage Aps=new AdminProductspage(driver);
			Aps.EditProductsdetails(driver);
			
			
			

	}
}
