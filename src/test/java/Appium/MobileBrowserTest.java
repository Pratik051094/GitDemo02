package Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseClass {

	
	@Test
	public void BrowserTest() {
//		driver.get("https://www.google.com/");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("fb");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[@aria-label='Toggle navigation']")).click();
		driver.findElement(By.xpath("//a[@routerlink='/products']")).click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
		String text=driver.findElement(By.xpath("//a[text()='Devops']")).getText();
		Assert.assertEquals(text, "Devops");
	}
	
}
