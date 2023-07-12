package Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce extends BaseClass {
	
	@Test  
	public void EcommerceTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("pratik meher");
		//driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"India\").instance(0))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@index='6']")).click();
		Thread.sleep(3000);
	}

}
