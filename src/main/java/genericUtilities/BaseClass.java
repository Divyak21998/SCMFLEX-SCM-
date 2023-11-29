package genericUtilities;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com_ObjectRepo.Adminhomepage;
import com_ObjectRepo.LoginPage;

public class BaseClass {

	public WebDriverUtilies wlib=new WebDriverUtilies();
	public ExcelUtilities elib=new ExcelUtilities();
	public PropertyFileUtilities plib=new PropertyFileUtilities();
	public DatabaseUtilities dlib=new DatabaseUtilities();
	public WebDriver driver;
	public static WebDriver sdriver;
	//	Scanner sc=new Scanner(System.in);
	//	String dd=sc.next();

	@BeforeSuite(alwaysRun = true)
	public void config_Bs() throws Throwable
	{
		dlib.connectDB();
		System.out.println("-----connecting Database-----");	
	}
	//@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws Throwable
	{
		String Browser=plib.readDataFromPropertyFile("browser");

		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("---invalid browser----");
		}
		sdriver=driver;
		wlib.maximizeWindow(driver);
		wlib.waitForPageload(driver, 20);
		String Url=plib.readDataFromPropertyFile("url");
		driver.get(Url);


	}
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable
	{

		LoginPage login=new LoginPage(driver);
		String Adusername=plib.readDataFromPropertyFile("adminusername");
		String Adpassword=plib.readDataFromPropertyFile("adminpassword");
		String Adlogintype=plib.readDataFromPropertyFile("adminlogintype");
		String Retusername=plib.readDataFromPropertyFile("Retailerusername");
		String Retpassword=plib.readDataFromPropertyFile("Retailerurerpassword");
		String Retlogintype=plib.readDataFromPropertyFile("Retailerlogintype");
		String Manusername=plib.readDataFromPropertyFile("manufacturerusername");
		String Manpassword=plib.readDataFromPropertyFile("manufacturerpassword");
		String Manlogintype=plib.readDataFromPropertyFile("Manufacturerlogintype");



		//		 if(Adlogintype.equalsIgnoreCase(dd))
		//		 {

		Thread.sleep(3000);

		//if(Adlogintype.equalsIgnoreCase(dd))
		//{
		login.loginTOApplication(Adusername,Adpassword,Adlogintype);
		//		}
		//		else if(Retlogintype.equalsIgnoreCase(dd))
		//		{
		//			login.loginTOApplication(Retusername, Retpassword, Retlogintype);
		//		}
		//		else if(Manlogintype.equalsIgnoreCase(dd))
		//		{
		//			login.loginTOApplication(Manusername, Manpassword, Manlogintype);
		//		}
		//		else
		//		{
		//			System.out.println("---invalid login--");
		//		}
	}
	@AfterMethod(alwaysRun = true)
	public void config_AM()
	{
		Adminhomepage Ahome=new Adminhomepage(driver);
		Ahome.getLogout().click();

		System.out.println("logged out from appln");
	}
	@AfterClass(alwaysRun = true)
	public void config_AC()
	{
		driver.quit();
		System.out.println("-- browser closed---");
	}
	@AfterSuite(alwaysRun = true)
	public void config_AS() throws Throwable
	{
		dlib.disconnectDB();
		System.out.println("---disconnect database----");

	}
}
