package com.adjiva.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	protected void methodSetUp() {

		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("Method Setup");
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resources/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
		}

		driver = new ChromeDriver();

		driver.get("http://adjiva.com/qa-test/");
		driver.manage().window().fullscreen();
	}

	@AfterMethod
	protected void methodTearDown() {
		System.out.println("Method TearDown");
		driver.quit();
	}

}
