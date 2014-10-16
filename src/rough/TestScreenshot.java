package rough;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

public class TestScreenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com/");
		// Screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Screenshots\\google.jpg"));
	}

}
