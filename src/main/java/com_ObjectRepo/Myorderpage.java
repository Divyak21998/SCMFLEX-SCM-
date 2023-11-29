package com_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtilies;

public class Myorderpage extends WebDriverUtilies{

	public WebDriver driver;
	//declaration
	@FindBy(id="cmbFilter")
	private WebElement searchby;
	@FindBy(id="txtId")
	private WebElement idtextfield;
	@FindBy(id="datepicker")
	private WebElement datetextfied;
	@FindBy(xpath=("//select[@data-handler='selectMonth']"))
	private WebElement mothdropdown;
	@FindBy(xpath=("//a[.='10']"))
	private WebElement day;
	@FindBy(id="cmbStatus")
	private WebElement statusdropdown;
	@FindBy(id="cmbApproved")
	private WebElement approveddropdown;
	@FindBy(xpath=("//input[@type='submit']"))
	private WebElement searchbutton;
	@FindBy(xpath=("//span[@class='error_message']"))
	private WebElement errormessage;
	//initializing
	public Myorderpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilizing
	public WebElement getSearchby() {
		return searchby;
	}
	
	public WebElement getIdtextfield() {
		return idtextfield;
	}
	
	public WebElement getDatetextfied() {
		return datetextfied;
	}
	
	public WebElement getMothdropdown() {
		return mothdropdown;
	}
	
	public WebElement getDay() {
		return day;
	}
	
	public WebElement getStatusdropdown() {
		return statusdropdown;
	}
	
	public WebElement getApproveddropdown() {
		return approveddropdown;
	}
	
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	public WebElement getErrormessage() {
		return errormessage;
	}
	//business logic
	public void searchbyitemId(String Idoption,String Idnum)
	{
		WebElement ele = searchby;
		dropdownbyvisibletext(ele, Idoption);
		idtextfield.sendKeys(Idnum);
		searchbutton.click();
	}
	public void searchbyitemDate(String dateoption,String monthoption)
	{
		WebElement ele1 = searchby;
		dropdownbyvisibletext(ele1, dateoption);
		datetextfied.click();
		WebElement ele2=mothdropdown;
		dropdownbyvisibletext(ele2, monthoption);
		day.click();
		searchbutton.click();
	}
	public void seachbyitemstatus(String statusoption,String option)
	{
		WebElement ele1 = searchby;
		dropdownbyvisibletext(ele1, statusoption);
		WebElement ele2=statusdropdown;
		dropdownbyvisibletext(ele2, option);
		searchbutton.click();
		
	}
	public void seachByItemApprovedoption(String approvaloption,String option)
	{
		WebElement ele1 = searchby;
		dropdownbyvisibletext(ele1,approvaloption);
		WebElement ele2=approveddropdown;
		dropdownbyvisibletext(ele2, option);
		searchbutton.click();
		
	}
	
}
