package genericUtilities;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilies {
	/**
	 * This method is used to maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to wait until page load
	 * @param driver
	 * @param sec
	 */
	public void waitForPageload(WebDriver driver,int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	/**
	 * This method is used to wait until element to be clickable
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waituntilElementtoVisible(WebDriver driver,WebElement element,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to select dropdown by using value
	 * @param element
	 * @param value
	 */
	public void dropdownbyvisibletext(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}
	/**
	 * This method is used to select dropdown by using indexnum
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method is used to select dropdown by using visibletext
	 * @param text
	 * @param element
	 */
	public void dropdown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(text);
	}
	
	/**
	 * This method is used to draganddrop the element
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void drapanddrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(src, dst).perform();
	}
	public void mouseoverontheelement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to doubleclick
	 * @param driver
	 */
	public void doubleclick(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.doubleClick().click().perform();
		
	}
	public void doubleclickonElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).click().perform();
		
	}
	/**
	 * Thi
	 * @param driver
	 */
	public void rightclick(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.contextClick().click().perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightclickonElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param text
	 */
	public void keypress(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void keyPress() throws Throwable
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	public void keyRelease() throws Throwable
	{
		Robot robot=new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to switch driver control to frame by using index reference
	 * @param driver
	 * @param index
	 */
	public void switchtoFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch driver control to frame by using name or ID locator
	 * @param driver
	 * @param nameorId
	 */
	public void switchtoFrame(WebDriver driver,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	
	/**
	 * This method is used to switch driver control to frame by using element adress
	 * @param driver
	 * @param elementaddress
	 */
	public void switchtoFrame(WebDriver driver,WebElement elementaddress)
	{
		driver.switchTo().frame(elementaddress);
	}
	
	public void acceptalert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void cancelalert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void gettextfromalert(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
	}
	
	
	public void switchtowindow(WebDriver driver,String partialWintitle)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it= window.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String currentwinid = driver.switchTo().window(winId).getTitle();
			if(currentwinid.equals(partialWintitle))
			{
				break;
			}
		}
	}
	
	
	
	public void scrollByAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	public void javascriptclick(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	public  static String takeScreenshots(WebDriver driver,String screenshot) throws Throwable 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\Screenshot\\"+screenshot+".png";
		File des=new File(path);
		
			  FileUtils.copyFile(src,des);
			  //return des.getAbsolutePath();
			 return path;
		
	}
}


