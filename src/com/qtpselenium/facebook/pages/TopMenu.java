package com.qtpselenium.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenim.testcases.TestBase;
import com.qtpselenium.util.Constants;

public class TopMenu {
	
	@FindBy(xpath=Constants.Droplistbox)
	WebElement dropList;
	@FindBy(xpath=Constants.AccountSettings)
	WebElement accountsettingsLink;
	@FindBy(xpath=Constants.homepage)
	WebElement homepage;
	
	WebDriver driver;
	
	public TopMenu(WebDriver dr){
		driver=dr;
	}
	
	public AccountSettings gotoAccountSettings() throws InterruptedException{
		dropList.click();
		Thread.sleep(3000L);
		accountsettingsLink.click();
		return PageFactory.initElements(driver, AccountSettings.class);
	}
	
	public void Logout(){
		TestBase.isLoggedIn=false;
		
	}
	
	public LandingPage gotoLandingPage(){
		homepage.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}

}
