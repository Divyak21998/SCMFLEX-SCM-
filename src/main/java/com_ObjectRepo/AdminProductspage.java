package com_ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminProductspage {
	@FindBy(xpath=("//input[@value='1']"))
	private WebElement stackmanagmentcheckbox;
	
   public AdminProductspage(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }

public WebElement getStackmanagmentcheckbox() {
	return stackmanagmentcheckbox;
}

public void UpdateProductNameAlongWithprice(WebDriver driver)
{ 
	 
		WebElement textproduct = driver.findElement(By.xpath("//table/tbody/tr[251]/td[3]"));		
		String productname = textproduct.getText();

		WebElement productquantity = driver.findElement(By.xpath("//table/tbody/tr[251]/td[7]"));

		String prductQuantity = productquantity.getText();
		System.out.println("Product name : " + productname + " Product Quantity : " + prductQuantity);
}
}
