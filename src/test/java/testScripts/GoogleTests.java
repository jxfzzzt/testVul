/*
Author: Aman Ur Rahman
Program: GoogleTests
Description:
This class consists of all the individual tests that are applied to Google Search Results
*/
package testScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import setupTeardown.SetupTeardownForGoogleTests;

public class GoogleTests extends SetupTeardownForGoogleTests {

	@Test(priority = 1)
	public void PopularityCheck() {
		extentTest = extentReports.createTest("PopularityCheck");
		Log.info("Popularity check method has initiated");
		extentTest.log(Status.INFO, "PopularityCheck has started");
		driver.findElement(By.xpath("//input[@name='q']")).clear();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Aman ur rahman14343");
		if (cloudTesting.equals(true)) {
			driver.findElement(By.xpath("//input[@name='q']")).submit();
		} else if (cloudTesting.equals(false)) {
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@type='submit']")));
		}
		Log.info("Search clicked after entering data");
		extentTest.log(Status.INFO, "Details entered successfully and clicked on Search");
		if (driver.findElements(By.xpath("//div[@id='result-stats']")).size() > 0) {
			Long SearchResults = Long
					.valueOf(driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split("results")[0]
							.split(" ")[1].replace(",", ""));
			if (SearchResults > 1000000) {
				System.out.println("The input is famous and has many over a million results");
			} else {
				System.out.println("The input is not that famous and has few search results");
			}

		} else
			System.out.println("The element is not present on the screen");
		Log.info("Popularity check method has completed after evaluation of popularity of search object");
		extentTest.log(Status.INFO, "Checked popularity successfully");
	}

	@Test(priority = 2)
	public void DoodleDay() {
		extentTest = extentReports.createTest("DoodleDay");
		Log.info("Doodle check method has initiated");
		extentTest.log(Status.INFO, "DoodleDay has started");
		if (driver.findElements(By.xpath("//img[@src='/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png']")).size() > 0) {
			System.out.println("The GOOGLE image is displayed");
			Log.info("Today is not a Doodle day");
			extentTest.log(Status.INFO, "Google image displayed, therefore not a Doodle day");
		} else {
			Log.info("Today is not a Doodle day");
			extentTest.log(Status.FAIL, "Google image not displayed, therefore a Doodle day");
			Assert.fail("Today is not a Doodle day");
		}
		

	}

}
