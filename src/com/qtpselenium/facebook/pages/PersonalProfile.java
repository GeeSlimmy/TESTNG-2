package com.qtpselenium.facebook.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.util.Constants;

public class PersonalProfile {
	
	@FindBy(xpath=Constants.friendslink)
	WebElement friendLink;
	@FindBy(xpath=Constants.updatephoto)
	WebElement updatephoto;
	@FindBy(xpath=Constants.choosephoto)
	WebElement choosephoto;
	
	WebDriver driver;
	
	public PersonalProfile(WebDriver dr){
		driver=dr;
	}
	
	public FriendList loadFriendList(){
		friendLink.click();
		return PageFactory.initElements(driver, FriendList.class);
	}
	
	
	public void changeProfilePic(String newpicpath) throws InterruptedException{
		updatephoto.click();
		Thread.sleep(3000L);
		/*
		choosephoto.sendKeys(Keys.DOWN);
		choosephoto.sendKeys(Keys.DOWN);
		choosephoto.sendKeys(Keys.DOWN);
		choosephoto.sendKeys(Keys.ENTER);
		*/
		choosephoto.sendKeys(newpicpath);
		
		
	}

}
