package com.qtpselenium.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qtpselenium.util.Constants;
import com.qtpselenium.util.ErrorUtil;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(xpath=Constants.username) // must have "public static final" as function //
	public WebElement username;
	
	@FindBy(xpath=Constants.password)
	public WebElement password;
	
	public LoginPage(WebDriver dr){
		driver=dr;
		
	}
	
	public LandingPage doLogin(String Uname, String Pword){
		driver.get("http://facebook.com/"); // Config URL kept
		// Verify Title page
		try{
		Assert.assertEquals(driver.getTitle(), Constants.fbhomepagetitle);
		}catch(Throwable e){
			System.out.println("Error --");
			// tell ur reports - error has come
			ErrorUtil.addVerificationFailure(e);
			
			// take screenshot //
		}
		username.sendKeys(Uname);
		password.sendKeys(Pword);
		password.sendKeys(Keys.ENTER);
		// validate successful login
		int count = driver.findElements(By.xpath(Constants.profileNameLink)).size();
		if(count==0)
			return null;
		else{
		LandingPage landingpage = PageFactory.initElements(driver, LandingPage.class);
		return landingpage;
		
		}
	}   

}
