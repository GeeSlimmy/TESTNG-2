package com.qtpselenium.util;

public class Constants {
	
	// PATHS 
	public static String CONFIG_FILE_PATH = System.getProperty("user.dir")+"//src//com//qtpselenium//config//config.properties";
	// xpath, ids object identification goes here //
	// Login Page //
	public static final String username="//*[@id='email']";
	public static final String password="//*[@id='pass']";
	
	// Landing Page //
	public static final String profileNameLink="//*[@id='pagelet_welcome_box']/div/div/div/div[2]/a[1]";
	
	
	// Personal Profile //
	public static final String friendslink="//div[@id='fbTimelineHeadline']/div[2]/div/a[4]";
	public static final String updatephoto="//div[@class='fbTimelineProfilePicSelector _23fv']/div/a";
	public static final String choosephoto="html/body/div[1]/div[2]/div[3]/div/div/div/ul/li[3]/a/span/span/form/div/a/div/input";//"//div[@id='u_f_2']/a/div/input";
	//*[@id='u_jsonp_2_b']/img              html/body/div[1]/div[2]/div[5]/div/div/div/ul/li[3]/a/span/span/form/div/a/div/input
	//*[@id='u_2_0']/div/ul/li[3]/a/span
	
	// Friend List //
	public static final String friendSearchbox="html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div/div/div/span/span/input";
	                                            //html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div/div/div/span/span/input
	
	// Top Menu //
	public static final String Droplistbox="//*[@id='userNavigationLabel']";
	public static final String AccountSettings="//*[@id='userNavigationMenu']/ul/li[7]/a";
	public static final String homepage="html/body/div[1]/div[1]/div/div/div[1]/div/h1/a";
	                                           
	
	// Account Settings //
	public static final String Editpassword ="//*[@id='SettingsPage_Content']/ul/li[4]/a/span[1]";
	public static final String oldpassword ="//*[@id='password_old']";
	public static final String newpassword ="//*[@id='password_new']";
	public static final String confirmpassword ="//*[@id='password_confirm']";
	public static final String confirmbutton ="//label[@class='submit uiButton uiButtonConfirm']/input";
	//*[@id='password_old']
	//*[@id='password_new']
	//*[@id='password_confirm']
	//label[@class='submit uiButton uiButtonConfirm']/input
	
	// Title / Text
	public static final String fbhomepagetitle="Welcome to Facebook - Log In, Sign Up or Learn More";

}
