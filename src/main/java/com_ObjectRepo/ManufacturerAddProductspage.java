package com_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtilies;

public class ManufacturerAddProductspage extends WebDriverUtilies{
	@FindBy(id="product:name")
	private WebElement productnametxt;
	@FindBy(id="product:price")
	private WebElement productpricetxt;
	@FindBy(id="product:unit")
	private WebElement productunitdd;
	@FindBy(id="product:category")
	private WebElement productcategorydd;
	@FindBy(xpath=("//input[@value='1']"))
	private WebElement stockmanagementcheckbox;
	@FindBy(id="product:description")
	private WebElement productdes;
	@FindBy(xpath=("//input[@type='submit']"))
	private WebElement addproductbutton;

	public ManufacturerAddProductspage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getProductnametxt() {
		return productnametxt;
	}

	public WebElement getProductpricetxt() {
		return productpricetxt;
	}

	public WebElement getProductunitdd() {
		return productunitdd;
	}
	public WebElement getProductcategorydd() {
		return productcategorydd;
	}
	public WebElement getStockmanagementcheckbox() {
		return stockmanagementcheckbox;
	}
	public WebElement getProductdes() {
		return productdes;
	}
	public WebElement getAddproductbutton() {
		return addproductbutton;
	}

	public void Manufacturerabletoaddproduct(String pname,String pprice,String unitoption,String categoryoption,String description )
	{
		productnametxt.sendKeys(pname);
		productpricetxt.sendKeys(pprice);
		WebElement unitdd = productunitdd;
		dropdownbyvisibletext(unitdd,unitoption); 
		WebElement categorydd = productcategorydd;
		dropdownbyvisibletext(categorydd,categoryoption); 
		stockmanagementcheckbox.click();
		productdes.sendKeys(description);
		addproductbutton.click();
	}
}
