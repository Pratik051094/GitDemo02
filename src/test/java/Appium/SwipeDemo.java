package Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class SwipeDemo extends BaseClass {

	
	@Test
	public void SwipeDemo() {
		driver.findElement(By.xpath("//android.widget.TextView[@index='11']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Gallery']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement FirstImage=driver.findElement(By.xpath("//android.widget.ImageView[@index='0']"));
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).getAttribute("focusable"), "true");
		SwipeAction(FirstImage,"left");
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).getAttribute("focusable"), "false");
	}
}
