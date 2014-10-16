package com.qtpselenim.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.*;

import com.qtpselenium.facebook.pages.LandingPage;
import com.qtpselenium.facebook.pages.LoginPage;
import com.qtpselenium.facebook.pages.PersonalProfile;
import com.qtpselenium.util.ErrorUtil;
import com.qtpselenium.util.TestUtil;

public class UploadPic extends TestBase{
	
	@Test
	public void UploadPic (){
		APPLICATION_LOGS.debug("Executing the upload pic test");
		 if(!TestUtil.isExecutable("UploadPic", xls))
				throw new SkipException("Skipping the test");
		
		LandingPage landingPage =null;
		// Go to landing page of FB
		if(!isLoggedIn){
			// Login
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
			landingPage = lp.doLogin(CONFIG.getProperty("defaultUsername"), CONFIG.getProperty("defaultPassword"));
		}else{
		landingPage = getTopMenu().gotoLandingPage();
		}
		//LandingPage landingPage = gotoLandingPage();
		PersonalProfile personalProfile = landingPage.gotoprofilePage();
		// Change Pic
		APPLICATION_LOGS.debug("Quitting the Driver");
		try{
		Assert.assertTrue(false, "xxxxx");
		}catch(Throwable e){
			ErrorUtil.addVerificationFailure(e);
			TestUtil.taskScreenshot("Upload");
			return;
		}
		quitDriver();
		
		
	}

}
