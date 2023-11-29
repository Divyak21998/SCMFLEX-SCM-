package com_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProductPage {
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement logoutbutton;
	@FindBy(id="product:name")
	private WebElement productnametxt;
	@FindBy(id="product:price")
	private WebElement productpricetxt;
	@FindBy(xpath=("//input[@value='1']"))
	private WebElement stockmanagementcheckbox;
	@FindBy(xpath=("//input[@value='Update Product']"))
	private WebElement upadateproductbutton;
	public EditProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getLogoutbutton() {
		return logoutbutton;
	}
	public WebElement getProductnametxt() {
		return productnametxt;
	}

	public WebElement getProductpricetxt() {
		return productpricetxt;
	}
	public WebElement getStockmanagementcheckbox() {
		return stockmanagementcheckbox;
	}
	public WebElement getUpadateproductbutton() {
		return upadateproductbutton;
	}
	public void Editproduct() {
		getProductnametxt().clear();
		getProductpricetxt().clear();
		getProductnametxt().sendKeys("Frozen spicy peas");
		getProductpricetxt().sendKeys("100");
		getStockmanagementcheckbox().click();
		getUpadateproductbutton().click();
	}
}
