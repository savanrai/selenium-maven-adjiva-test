package com.adjiva.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adjiva.base.BaseTest;

public class UserRegistrationTests extends BaseTest {

	@DataProvider(name = "TestDataUserRegistration")
	public Object[][] dataProvider() {
		return new Object[][] {
				{ "Tom", "Cruise", "Sales", "Cruise07", "Password@1", "Password@1", "Cruise@gmail.com", "9593495345" },
				{ "George", "Clooney", "Support", "George01", "Password@123", "Password@123", "George@gmail.com",
						"9993495699" } };
	}

	@Test(dataProvider = "TestDataUserRegistration")
	public void UserRegistration(String firstName, String secondName, String department, String userName,
			String password, String confirmPassword, String email, String phoneNumber) {

			driver.findElement(By.name("first_name")).sendKeys(firstName);
			driver.findElement(By.name("last_name")).sendKeys(secondName);

			Select selectDepartment = new Select(driver.findElement(By.xpath("//select[@name='department']")));
			selectDepartment.selectByVisibleText(department);

			driver.findElement(By.name("user_name")).sendKeys(userName);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.name("confirm_password")).sendKeys(confirmPassword);
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("contact_no")).sendKeys(phoneNumber);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			String successMessage = driver.findElement(By.xpath("//b[contains(text(),'Thanks')]")).getText();
			Assert.assertEquals(successMessage, "Thanks");

	}

}
