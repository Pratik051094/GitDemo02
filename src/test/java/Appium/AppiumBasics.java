package Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumBasics extends BaseClass {

	@Test
	public void AppiumTest() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@index='2']")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@index='0']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		String WifiText=driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).getText();
		Assert.assertEquals(WifiText, "WiFi settings");
        driver.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys("wifi-connect");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}

}
