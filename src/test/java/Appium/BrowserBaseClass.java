package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseClass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
	    service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\pmeher\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("pratikMobile1");
		options.setChromedriverExecutable("C:\\Users\\pmeher\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\mobileApp\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
	      driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void stopdownAppium() {
		driver.quit();
		service.stop();
	}
	

}
