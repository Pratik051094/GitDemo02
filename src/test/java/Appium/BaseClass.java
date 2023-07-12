package Appium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws IOException {
		Properties pro = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.propertie");
		pro.load(file);
		String Ipadress=pro.getProperty("Ipadress");
		String portNo=pro.getProperty("portNo");
		String AndroidDeviceName=pro.getProperty("AndroidDeviceName");
		
	    service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\pmeher\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress(Ipadress).usingPort(Integer.parseInt(portNo)).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(AndroidDeviceName);
		options.setChromedriverExecutable("C:\\Users\\pmeher\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\mobileApp\\chromedriver.exe");
		//options.setApp("C:\\Users\\pmeher\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\mobileApp\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\pmeher\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\mobileApp\\General-Store.apk");
	      driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass
	public void stopdownAppium() {
		driver.quit();
		service.stop();
	}

	
	public void LongPress(WebElement Ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)Ele).getId(),"duration",2000));
	}
	
	public void ScrollToEndAction() {
		boolean canScrollMore ;
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));}while(canScrollMore);
	}
	
	public void SwipeAction(WebElement ele,String Dir) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)ele).getId(),
			    "direction", Dir,
			    "percent", 0.75
			));
	}
}
