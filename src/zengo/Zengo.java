package zengo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zengo {
	WebDriver driver;
	
	public Zengo() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromeDriver.exe");
		driver = new ChromeDriver();
	}

	public void launchBrowser() {
		driver.get("https://zengo.com/");
	}

	public static void main(String[] args) {
		Zengo z1 = new Zengo();
		z1.launchBrowser();
	}


}
