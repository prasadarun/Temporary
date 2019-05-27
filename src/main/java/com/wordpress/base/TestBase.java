package com.wordpress.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.wordpress.utils.LoadingTime;

public class TestBase {


	public static WebDriver driver;
	public static Properties prop;


	/*** .... ......Created Constructor to load the data .........****/

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/wordpress/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/*** ........ Initializing the browser .........****/

	public static void intilization() {

		String browserName  = prop.getProperty("browser");
		String Type_of_run = prop.getProperty("Type_of_run");
		System.out.println("Selected browser type is:"+ Type_of_run);

		if(Type_of_run.equals("headless")){

			if(browserName.equals("chrome")){
				driver = new HtmlUnitDriver(BrowserVersion.CHROME);
				System.out.println(BrowserVersion.CHROME);
			}


			else if(browserName.equals("Firefox")) {
				driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_45);
			}


			else if (browserName.equals("nill")){
				driver = new HtmlUnitDriver();
			}




		}

		else if(Type_of_run.equals("head")){

			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "/Users/durga/selenium drivers/chromedriver");
				driver = new ChromeDriver();	
			}
			else if(browserName.equals("Firefox")){
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\dpindi.CORP\\Desktop\\Selenium practice\\Drivers.exe files\\geckodriver.exe");
				driver = new FirefoxDriver();	
			}

			else {
				System.out.print("No other browsers are defined");
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(LoadingTime.PAGE_LAYOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);

		}

		driver.get(prop.getProperty("url"));


	}
}

