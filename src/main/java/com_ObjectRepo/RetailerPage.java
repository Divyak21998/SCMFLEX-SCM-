package com_ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerPage {
	
	@FindBy(xpath=("//a[.='Retailers']"))
	private WebElement retailerslink;
	
	@FindBy(xpath=("//input[@value='Delete']"))
	private WebElement deletebutton;
	 
	public RetailerPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getRetailerslink() {
		return retailerslink;
	}

	

	public WebElement Checkbox(WebDriver driver,String name) {
		WebElement checkbox=driver.findElement(By.xpath(("//td[(.=' "+name+" ')]/..//input[@type='checkbox']")));
		 return checkbox;
	}

	

	public WebElement getDeletebutton() {
		return deletebutton;
	}

	
}
