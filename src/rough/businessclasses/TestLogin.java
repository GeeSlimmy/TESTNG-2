package rough.businessclasses;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import com.qtpselenium.facebook.pages.LandingPage;
import com.qtpselenium.facebook.pages.LoginPage;
import com.qtpselenium.util.Constants;

public class TestLogin {

	public static void main(String[] args) {
		// initializing config file
		// initializing logs
		// FF, IE, CHROME //
		Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
		APPLICATION_LOGS.debug("Starting Test");
		
		Properties CONFIG = new Properties();
		try{
		FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
		CONFIG.load(fs);
		} catch (Exception e){
			e.printStackTrace();
		WebDriver driver = null;
		if(CONFIG.getProperty("browser").equals("Mozilla"))
			driver=new FirefoxDriver();
		else if(CONFIG.getProperty("browser").equals("IE"))
			driver=new InternetExplorerDriver();
		else if(CONFIG.getProperty("browser").equals("Chrome"))
			driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		LandingPage landingpage = lp.doLogin("mekonecbsflyid@gmail.com", "elements1");
		APPLICATION_LOGS.debug("Logged in");
		landingpage.gotoprofilePage();
		APPLICATION_LOGS.debug("In Profile Page");
		
		}

	}

}
