package zengo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.junit.Assert;

public class Zengo {
	WebDriver driver;

	public Zengo() {
		String path = System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromeDriver.exe");
		System.out.print(path);
		driver = new ChromeDriver();
	}

	public void launchBrowser() throws InterruptedException {
		driver.get("https://zengo.com/");
	}

	@Test
	public void testAssertLaunching() throws InterruptedException {
		String title = driver.getTitle();
		String ExpectedTitle = "ZenGo - Simple & Secure Crypto Wallet App";
		Assert.assertEquals(ExpectedTitle, title);
	}
	
	public void clickOnEthereum() {
		driver.manage().window().maximize();
		WebElement assets = driver.findElement(By.id("menu-item-12609"));
		Actions a = new Actions(driver);
		a.moveToElement(assets).perform();
		WebElement ethereum = driver.findElement(By.linkText("Ethereum (ETH)"));
		a.moveToElement(ethereum).click().perform();
	}

		public static void main(String[] args) throws InterruptedException {
		Zengo z1 = new Zengo();
		z1.launchBrowser();
		z1.testAssertLaunching();
		z1.clickOnEthereum();
	}


}
