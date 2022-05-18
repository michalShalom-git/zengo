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
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromeDriver.exe");
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

	@Test
	public void testAssertEthereum() throws InterruptedException {
		String url = driver.getCurrentUrl();
		String ExpectedUrl = "https://zengo.com/assets/ethereum-wallet/";
		Assert.assertEquals(ExpectedUrl, url);
	}
	
	@Test
	public void testAssertLogo() throws InterruptedException {
		Boolean logoDisplay = driver.findElement(By.xpath("//img[@alt=\"zengo logo\"]")).isDisplayed();
		Assert.assertTrue(logoDisplay);
	}
	
	public void homePage() {
		driver.findElement(By.xpath("//img[@alt=\"zengo logo\"]")).click();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Zengo z1 = new Zengo();
		z1.launchBrowser();			//1
		z1.testAssertLaunching();	//2
		z1.clickOnEthereum();		//3
		z1.testAssertEthereum();	//4
		z1.testAssertLogo();		//5
		z1.homePage();				//6
	}


}
