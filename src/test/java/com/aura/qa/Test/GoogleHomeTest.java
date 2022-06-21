package com.aura.qa.Test;

import com.aura.qa.util.TestFunctions;
import com.aura.qa.Constants;
import com.aura.qa.Pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleHomeTest {

	private static WebDriver driver;
	private String URL_HOME = "https://www.google.com";

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
		driver.get(URL_HOME);
		GooglePage googlePage = new GooglePage(driver);
		googlePage.clickAcceptButton();
		assertTrue(googlePage.checkGoogleImage());
		googlePage.searchText("ifema");
		assertTrue(googlePage.checkResults());
	}

}
