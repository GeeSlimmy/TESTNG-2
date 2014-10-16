package com.qtpselenim.testcases;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.facebook.pages.FriendList;
import com.qtpselenium.facebook.pages.LandingPage;
import com.qtpselenium.facebook.pages.LoginPage;
import com.qtpselenium.facebook.pages.PersonalProfile;
import com.qtpselenium.util.Constants;
import com.qtpselenium.util.TestUtil;
import com.qtpselenium.util.Xls_Reader;

public class LoginTest extends TestBase{
	LandingPage landingPage=null;
	
	@BeforeSuite
	public void init(){
		initConfigurations();
		initDriver();
	}

	
	
	@Test(dataProvider="getLoginData")
	public void loginTest(Hashtable<String,String>data){
		 
		 if(!TestUtil.isExecutable("LoginTest", xls) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");	
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		landingPage = lp.doLogin(data.get("Username"), data.get("Password"));
		Assert.assertTrue(landingPage!=null, "Could NOT login");
		isLoggedIn=true;
		APPLICATION_LOGS.debug("Logged in");
		//landingPage.gotoprofilePage();
		APPLICATION_LOGS.debug("In Profile Page");
		
	}
	@DataProvider
	public Object[][] getLoginData(){
		return TestUtil.getData("LoginTest", xls);
	}
		
		@Test(dependsOnMethods={"loginTest"})
		public void findFriend(){
			String friendName="Ron Hill";
		    Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\data\\Test Cases.xlsx");
		    if(!TestUtil.isExecutable("FindFriendTest", xls))
			throw new SkipException("Skipping the test");	
			PersonalProfile personalprofile = landingPage.gotoprofilePage();
			//personalprofile.loadFriendList();
			FriendList frdlst = personalprofile.loadFriendList();
			boolean b = frdlst.findAfriend(friendName);
			Assert.assertTrue(b, "Friend NOT found "+ friendName);
		
		
		}
	
	    
	}


