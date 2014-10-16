package rough.businessclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.facebook.pages.LandingPage;
import com.qtpselenium.facebook.pages.LoginPage;
import com.qtpselenium.facebook.pages.PersonalProfile;

public class UploadPic {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		LandingPage landingpage = lp.doLogin("mekonecbsflyid@gmail.com", "elements1");
		PersonalProfile personalProfile = landingpage.gotoprofilePage();
		personalProfile.changeProfilePic("C:\\Users\\lisa.lisaogawa\\Desktop\\FungPic.jpg");
	}

}
