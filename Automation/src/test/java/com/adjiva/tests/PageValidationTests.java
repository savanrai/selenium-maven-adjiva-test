package com.adjiva.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adjiva.base.BaseTest;

public class PageValidationTests extends BaseTest {

	@Test
	public void requiredFieldValidation() {

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String expected_errorFirstName = driver
				.findElement(By.xpath("//small[contains(text(),'Please enter your First Name')]")).getText();
		String actual_errorFirstName = "Please enter your First Name";
		Assert.assertEquals(expected_errorFirstName, actual_errorFirstName);

		String expected_errorLastName = driver
				.findElement(By.xpath("//small[contains(text(),'Please enter your Last Name')]")).getText();
		String actual_errorLastName = "Please enter your Last Name";
		Assert.assertEquals(expected_errorLastName, actual_errorLastName);

		String expected_errorUserName = driver
				.findElement(By.xpath("//small[contains(text(),'Please enter your Username')]")).getText();
		String actual_errorUserName = "Please enter your Username";
		Assert.assertEquals(expected_errorUserName, actual_errorUserName);

		String expected_errorPassword = driver
				.findElement(By.xpath("//small[contains(text(),'Please enter your Password')]")).getText();
		String actual_errorPassword = "Please enter your Password";
		Assert.assertEquals(expected_errorPassword, actual_errorPassword);

		String expected_errorConfirmPassword = driver
				.findElement(By.xpath("//small[contains(text(),'Please confirm your Password')]")).getText();
		String actual_errorConfirmPassword = "Please confirm your Password";
		Assert.assertEquals(expected_errorConfirmPassword, actual_errorConfirmPassword);

		String expected_errorEmail = driver
				.findElement(By.xpath("//small[contains(text(),'Please enter your Email Address')]")).getText();
		String actual_errorEmail = "Please enter your Email Address";
		Assert.assertEquals(expected_errorEmail, actual_errorEmail);

	}

	@Test
	public void minimumFieldValidation() {

		String actual_error = "This value is not valid";

		driver.findElement(By.name("first_name")).sendKeys("A");
		String expected_errorFirstName = driver.findElement(By.xpath("//fieldset//div[1]//div[1]//small[1]")).getText();
		Assert.assertEquals(expected_errorFirstName, actual_error);

		driver.findElement(By.name("last_name")).sendKeys("A");
		String expected_errorLastName = driver.findElement(By.xpath("//fieldset//div[2]//div[1]//small[1]")).getText();
		Assert.assertEquals(expected_errorLastName, actual_error);

		driver.findElement(By.name("user_name")).sendKeys("AAAAAAA");
		String expected_errorUserName = driver.findElement(By.xpath("//fieldset//div[4]//div[1]//small[1]")).getText();
		Assert.assertEquals(expected_errorUserName, actual_error);

		driver.findElement(By.name("user_password")).sendKeys("AAAAAAA");
		String expected_errorUserPassword = driver.findElement(By.xpath("//fieldset//div[5]//div[1]//small[1]"))
				.getText();
		Assert.assertEquals(expected_errorUserPassword, actual_error);

		driver.findElement(By.name("confirm_password")).sendKeys("AAAAAAA");
		String expected_errorConfirmPassword = driver.findElement(By.xpath("//fieldset//div[6]//div[1]//small[1]"))
				.getText();
		Assert.assertEquals(expected_errorConfirmPassword, actual_error);
	}

	@DataProvider(name = "TestDataEmail")
	public Object[][] getEmailData() {
		return new Object[][] { { "abc" }, { "abc@test" }, { "abc@gmail" }, { "abc@gmail." } };
	}

	@Test(dataProvider = "TestDataEmail")
	public void emailFieldValidation(String email) {

		String actual_error = "This value is not valid";
		WebElement errorEmail = driver.findElement(By.xpath("//fieldset//div[7]//div[1]//small[2]"));

		driver.findElement(By.name("email")).sendKeys(email);
		String expected_errorEmail = errorEmail.getText();
		Assert.assertEquals(expected_errorEmail, actual_error);
	}
	
	@DataProvider(name = "TestDataPhoneNumber")
	public Object[][] getPhoneNumberData() {
		return new Object[][] { { "abc" }, { "12345678901" }, { "+911234569" }, { "123456789" } };
	}

	@Test(dataProvider = "TestDataPhoneNumber")
	public void phoneNumberValidation(String phoneNumber) {

		String actual_error = "This value is not valid";
		WebElement errorPhoneNumber = driver.findElement(By.xpath("//fieldset//div[8]//div[1]//small[1]"));

		driver.findElement(By.name("contact_no")).sendKeys(phoneNumber);
		String expected_errorPhoneNumber = errorPhoneNumber.getText();
		Assert.assertEquals(expected_errorPhoneNumber, actual_error);
	}

}
