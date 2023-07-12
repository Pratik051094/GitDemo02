package Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseClass {
	
	@Test 
	public void ScrollDemo() {
		driver.findElement(By.xpath("//android.widget.TextView[@index='11']")).click();
		//not working code
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollintoView(text(\"WebView2\"));"));
		//working code
	    //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"WebView2\").instance(0))"));
		ScrollToEndAction();
	}

}
