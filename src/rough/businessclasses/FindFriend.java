package rough.businessclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.facebook.pages.FriendList;
import com.qtpselenium.facebook.pages.LandingPage;
import com.qtpselenium.facebook.pages.LoginPage;
import com.qtpselenium.facebook.pages.PersonalProfile;

public class FindFriend {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		LandingPage landingpage = lp.doLogin("mekonecbsflyid@gmail.com", "elements1");
		PersonalProfile personalprofile = landingpage.gotoprofilePage();
		personalprofile.loadFriendList();
		FriendList frdlst = personalprofile.loadFriendList();
		boolean b = frdlst.findAfriend("Ron Hill");
		if(b)
			System.out.println("Friend Found");
		else
			System.out.println("NOT Found");
	}

}
