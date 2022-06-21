package com.aura.qa.Test;

import com.aura.qa.Pages.AuraHomePage;
import com.aura.qa.util.TestFunctions;
import com.aura.qa.util.Wait;
import com.aura.qa.Constants;
import com.aura.qa.Pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleHomeTest {

	private static WebDriver driver;
	private String URL_HOME = "https://auragroup.es/";

	@BeforeAll
	public static void setup() throws Exception {
		TestFunctions.loadConfiguration();
		driver = TestFunctions.configureDriver(Constants.DRIVER_SELECTED);
		driver.manage().window().maximize();
		TestFunctions.setTimeOut(driver);
	}

	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	@DisplayName("Check Google Search")
	@Tag("Search")
	public void searchTest() {
		driver.get("https://www.google.com/");
		GooglePage googlePage = new GooglePage(driver);
		Wait.waitSeconds(2);
		googlePage.clickAcceptButton();
		Wait.waitSeconds(2);
		assertTrue(googlePage.checkGoogleImage());
		Wait.waitSeconds(2);
		
		System.out.println("test");
	}

	

}
