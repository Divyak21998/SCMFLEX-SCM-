package com_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerProductspage {
	@FindBy(xpath="//input[@value='338']/../..//img[@alt='edit']")
	private WebElement edit;
	@FindBy(xpath=("//input[@id='product:price']"))
	private WebElement productpricetxt;
	@FindBy(xpath=("//input[@value='Update Product']"))
	private WebElement updateproductbutton;
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement logoutbutton;
	public ManufacturerProductspage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getProductpricetxt()
	{
		return productpricetxt;
	}
	public WebElement getEdit()
	{
		return edit;
	}
	public WebElement getUpdateproductbutton()
	{
		return updateproductbutton;
	}
	public WebElement getLogoutbutton()
	{
		return logoutbutton;
	}

}
