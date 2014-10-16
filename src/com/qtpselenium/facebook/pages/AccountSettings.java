package com.qtpselenium.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qtpselenium.util.Constants;

public class AccountSettings {
	
	@FindBy(xpath=Constants.Editpassword)
	WebElement editPasswordLink;
	@FindBy(xpath=Constants.oldpassword)
	WebElement oldPasswordInput;
	@FindBy(xpath=Constants.newpassword)
	WebElement newPasswordInput;
	@FindBy(xpath=Constants.confirmpassword)
	WebElement confirmPasswordInput;
	@FindBy(xpath=Constants.confirmbutton)
	WebElement confirmPasswordButton;

	public void changePassword(String oldpassword, String newpassword) {
		editPasswordLink.click();
		oldPasswordInput.sendKeys(oldpassword);
		newPasswordInput.sendKeys(newpassword);
		confirmPasswordInput.sendKeys(newpassword);
		

	}

}
