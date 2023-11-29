package com_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtilies;

public class AddRetailerspage {
	@FindBy(name="cmbAreaCode")
	private  WebElement areacodedd;
	@FindBy(name="txtRetailerPhone")
	private WebElement phonenumtxt;
	@FindBy(xpath=("//input[@value='Add Retailer']"))
	private WebElement addretailerbutton;

	public AddRetailerspage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
   public WebElement getAreacodedd()
   {
	   return areacodedd;
   }
   public WebElement getPhonenumtxt() {
    return phonenumtxt;
   }
   public WebElement getAddretailerbutton() {
	   return addretailerbutton;
   }
}
