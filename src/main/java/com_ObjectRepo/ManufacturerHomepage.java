package com_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomepage {
	@FindBy(xpath=("//a[text()='Add Products']"))
	private WebElement addproductslink;
	
	@FindBy(xpath=("//a[text()='Products']"))
	private WebElement productslink;
	 @FindBy(xpath=("//a[text()='Manage Stock']"))
	 private WebElement managestocklink;
	public ManufacturerHomepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getaddproductslink()
	{
		return addproductslink;
	}
	public WebElement getProductslink()
	{
		return productslink;
	}
	public WebElement getManagestocklink()
	{
		return managestocklink;
	}
}

