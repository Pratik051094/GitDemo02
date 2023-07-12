package Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class LongPress extends BaseClass{
	
	@Test
	public void LogPress() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@index='11']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		WebElement Ele=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		LongPress(Ele);
		String Menutext=driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
		Assert.assertEquals(Menutext,"Sample menu");
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
		
	}
	

}
