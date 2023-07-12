package Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment extends BaseClass {
	
	@Test
	public void Assignment() {
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='App']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Alert Dialogs']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='OK Cancel dialog with a message']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
	}

}
