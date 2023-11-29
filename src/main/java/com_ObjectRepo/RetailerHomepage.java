package com_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomepage {
	
	@FindBy(xpath=("//a[.='My Orders']"))
	private WebElement myorderslink;
	
	 public RetailerHomepage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }
	public WebElement getMyorderslink()
	{
		return myorderslink;
	}
}
