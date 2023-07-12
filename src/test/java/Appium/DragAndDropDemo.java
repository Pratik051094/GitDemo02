package Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class DragAndDropDemo extends BaseClass{
	
	@Test
	public void DrangAndDropDemo() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@index='11']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		WebElement source=driver.findElement(By.xpath("//android.view.View[@index='1']"));
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 614,
			    "endY", 549
			));
		
		Thread.sleep(3000);
		
		String Result=driver.findElement(By.xpath("//android.widget.TextView[@text='Dropped!']")).getText();
		Assert.assertEquals(Result, "Dropped!");
	}

}
