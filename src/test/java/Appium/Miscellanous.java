package Appium;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Miscellanous extends BaseClass {

	@Test
	public void Miscellanous() throws MalformedURLException {
//for window user this command type on cmd = adb shell dumpsys window | find "mCurrentFocus"
		
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@index='2']")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@index='0']")).click();
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		String WifiText=driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).getText();
		Assert.assertEquals(WifiText, "WiFi settings");
		driver.setClipboardText("wifi-connect");
        driver.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}
	
