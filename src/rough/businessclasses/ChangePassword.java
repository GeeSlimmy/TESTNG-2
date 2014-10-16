package rough.businessclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.facebook.pages.AccountSettings;
import com.qtpselenium.facebook.pages.LandingPage;
import com.qtpselenium.facebook.pages.LoginPage;
import com.qtpselenium.facebook.pages.PersonalProfile;
import com.qtpselenium.facebook.pages.TopMenu;

public class ChangePassword {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		LandingPage landingpage = lp.doLogin("mekonecbsflyid@gmail.com", "elements1");
		
		TopMenu topMenu = PageFactory.initElements(driver, TopMenu.class);
		AccountSettings acctSettings = topMenu.gotoAccountSettings();
		acctSettings.changePassword("elements1", "elements");

	}

}
