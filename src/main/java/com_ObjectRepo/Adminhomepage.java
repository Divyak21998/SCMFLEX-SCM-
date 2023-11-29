package com_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminhomepage {
	@FindBy(xpath=("//a[.='Add Retailers']"))
	private WebElement addretailerslink;
	
	@FindBy(xpath=("//a[text()='Products']")) 
	private WebElement productslink;
	
	@FindBy(xpath=("//a[.='Add Manufacturer']"))
	private WebElement addManufacturerlink;
	@FindBy(xpath=("//input[@value='Log out']"))
	private WebElement logout;
	
	
	 public Adminhomepage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }
	 public WebElement getAddretailerslink()
	 {
		 return addretailerslink;
	 }
	 public WebElement getProductslink()
	 {
		 return productslink;
	 }
	 public WebElement getAddManufacturerlink()
	 {
		 return addManufacturerlink;
	 }
	 public WebElement getLogout()
	 {
		 return logout;
	 }

}
