package Appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceAddToCartProduct extends BaseClass {
	@Test  
	public void EcommerceTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("pratik meher");
		//driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"India\").instance(0))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@index='6']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"PG 3\").instance(0))"));
		int count =driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<count;i++) {
			
			String Productname=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(Productname.equalsIgnoreCase("PG 3")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
			
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));
		
		String lastproduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastproduct, "PG 3");
	}

}
