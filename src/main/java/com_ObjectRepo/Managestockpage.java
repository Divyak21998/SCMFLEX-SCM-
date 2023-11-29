package com_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managestockpage {
	@FindBy(xpath=("//td/input[@name='txtQuantity[361]']"))
	private WebElement quantity;
	@FindBy(xpath=("//input[@value='Update Stock']"))
	private WebElement updatestock;
	@FindBy(xpath=("//input[@value='Log out']"))
	private WebElement logout;
	
	
	public Managestockpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getQuantity() {
		return quantity;
	}
	public WebElement getUpdatestock() {
		return updatestock;
	}
	public WebElement getlogout() {
		return logout;
	}
	
}
