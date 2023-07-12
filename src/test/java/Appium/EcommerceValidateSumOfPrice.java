package Appium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EcommerceValidateSumOfPrice extends BaseClass {
	@Test  
	public void EcommerceTest3() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("pratik meher");
		//driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"India\").instance(0))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@index='6']")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));
		List <WebElement> productlist =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count1=productlist.size();
		double TotalSum=0;
		for(int i =0;i<count1;i++) {
			
			String ProductText=productlist.get(i).getText();
			double price=Double.parseDouble(ProductText.substring(1));
			TotalSum = TotalSum+price;
		}
		
		String Totalprice=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double TotalSum1=Double.parseDouble(Totalprice.substring(1));
		Assert.assertEquals(TotalSum, TotalSum1);
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPress(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(4000);
		
		Set<String> context=driver.getContextHandles();
		for(String Contextname:context) {
			System.out.println(Contextname);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("fb");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}

}
