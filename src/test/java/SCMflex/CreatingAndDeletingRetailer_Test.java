package SCMflex;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com_ObjectRepo.AddRetailerspage;
import com_ObjectRepo.Adminhomepage;
import com_ObjectRepo.LoginPage;
import com_ObjectRepo.RetailerPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtilities;
import genericUtilities.PropertyFileUtilities;
import genericUtilities.WebDriverUtilies;

@Listeners(genericUtilities.Listenerutil.class)
public class CreatingAndDeletingRetailer_Test extends BaseClass{
	@Test(groups = "Systemtest")
	public  void CreatingAndDeletingRetailer_() throws InterruptedException, Throwable {
		//WebDriver driver=new ChromeDriver();
		//		PropertyFileUtilities plib=new PropertyFileUtilities();
		//		WebDriverUtilies wlib= new WebDriverUtilies();
		//	ExcelUtilities elib=new ExcelUtilities();
		//		wlib.maximizeWindow(driver);
		//	wlib.waitForPageload(driver, 20);



		//Fetching data from property file


		//				String BROWSER=plib.readDataFromPropertyFile("browser");
		//				String URL=plib.readDataFromPropertyFile("url");
		//				String username=plib.readDataFromPropertyFile("adminusername");
		//				String password=plib.readDataFromPropertyFile("adminpassword");
		//				String admintype=plib.readDataFromPropertyFile("adminlogintype");

		//login to application
		//		driver.get(URL);
		//		LoginPage login=new LoginPage(driver);
		//	login.loginTOApplication(username, password, admintype);

		//System.out.println(driver.getTitle()+" is dispalyed");

		//creating new Retailer
		Adminhomepage Ahome=new Adminhomepage(driver);
		Ahome.getAddretailerslink().click();
		String exp="Add Retailer";
		Assert.assertEquals(driver.getTitle(),exp);
		System.out.println("Add retailer page is displayed");



		//fetching data from excelfile
		HashMap<String, String> map = elib.readMultipleData("newRetailer", driver);

		//selecting dropdown

		String areavalue=elib.readDataFromExcel("newRetailer", 1, 3);
		AddRetailerspage addret=new AddRetailerspage(driver);
		WebElement areacoded=addret.getAreacodedd();
		wlib.dropdownbyvisibletext(areacoded, areavalue);


		for(Entry<String,String>set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		//read phonenumber from excelfile
		addret.getAddretailerbutton().click();
         
		wlib.gettextfromalert(driver);
		wlib.acceptalert(driver);

		//deleting retailer account
	  RetailerPage rp=new RetailerPage(driver);
		WebElement retailer=rp.getRetailerslink();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(retailer));
		retailer.click();
		System.out.println(driver.getTitle()+ " is displayed");
		String name=elib.readDataFromExcel("newRetailer", 0, 1);
		rp.Checkbox(driver, name).click();
		rp.getDeletebutton().click();
		wlib.gettextfromalert(driver);
		wlib.acceptalert(driver);


	}

}
