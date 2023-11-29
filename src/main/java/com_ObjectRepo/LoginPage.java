package com_ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtilies;

public class LoginPage extends WebDriverUtilies {
	
	 public WebDriver driver;
	 //declaration
	@FindBy(id="login:username")
	private WebElement username;
	@FindBy(id="login:password")
	private WebElement password;
	@FindBy(xpath=("//input[@type='submit']"))
	private WebElement loginbutton;
	@FindBy(id="login:type")
	private WebElement logintype;
	//intializing
	public LoginPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
//utilizing
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogintype() {
		return logintype;
	}
	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
//business logic
public void loginTOApplication(String Uname,String pwd,String option)
{
	username.sendKeys(Uname);
	password.sendKeys(pwd);
	WebElement ele = logintype;
	dropdownbyvisibletext(ele,option);
	loginbutton.click();
    
}
}

