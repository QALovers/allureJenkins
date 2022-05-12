package com.aura.qa.Test;

import com.aura.qa.Pages.AuraHomePage;
import com.aura.qa.util.TestFunctions;
import com.aura.qa.Constants;
import com.aura.qa.Pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuraHomeTest {

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
	@DisplayName("Check header")
	@Tag("Header")
	public void headerTest() {
		driver.get(URL_HOME);
		AuraHomePage home = new AuraHomePage(driver);

		if (home.cookiesPanel()) {
			home.clickAcceptCookies();
		}

		assertEquals(home.getTitle(), "Cultura");
	}

	@Test
	@DisplayName("Check Unete title")
	@Tag("Unete")
	public void uneteTitleTest() {
		String TEXT_TO_CHECK = "UNETE | Ofertas de empleo IT para trabajar en Aura Group";
		driver.get(URL_HOME);
		AuraHomePage home = new AuraHomePage(driver);

		if (home.cookiesPanel()) {
			home.clickAcceptCookies();
		}

		home.clickMenuOption("Únete!");

		assertEquals(TEXT_TO_CHECK, driver.getTitle());
	}

	@Test
	@DisplayName("Check contact form")
	@Tag("Contact Form")
	public void contactFormTest() {
		driver.get(URL_HOME);
		AuraHomePage home = new AuraHomePage(driver);

		if (home.cookiesPanel()) {
			home.clickAcceptCookies();
		}

		home.clickMenuOption("Contacto");

		ContactoPage contacto = new ContactoPage(driver);
		contacto.writeOnField("Nombre", "Elia");
		contacto.writeOnField("correo", "hola@qalovers.com");
		contacto.writeOnField("Mensaje", "Texto de ejemplo para el mensaje");
		assertTrue(contacto.checkSendButtonIsDisplayed());
	}

	@Test
	@DisplayName("Check services are displayed")
	@Tag("Services")
	public void serviciosTest() {
		driver.get(URL_HOME);
		AuraHomePage home = new AuraHomePage(driver);

		if (home.cookiesPanel()) {
			home.clickAcceptCookies();
		}

		home.clickMenuOption("Servicios");

		ServiciosPage servicio = new ServiciosPage(driver);

		assertEquals(servicio.checkCards(), 6);
	}

	@Test
	@DisplayName("Check contact title")
	@Tag("Contact Title")
	public void contactTitleTest() {
		String TEXT_TO_CHECK = "Contact - Aura IRC";
		driver.get(URL_HOME);
		AuraHomePage home = new AuraHomePage(driver);

		if (home.cookiesPanel()) {
			home.clickAcceptCookies();
		}

		home.clickMenuOption("Contacto");

		ContactoPage contacto = new ContactoPage(driver);
		contacto.clickEnglishFlag();

		assertEquals(TEXT_TO_CHECK, driver.getTitle());
	}

	@Test
	@DisplayName("Check if culture page is ok")
	@Tag("Culture")
	public void cultureTest() {
		driver.get(URL_HOME);
		AuraHomePage home = new AuraHomePage(driver);
		if (home.cookiesPanel()) {
			home.clickAcceptCookies();
		}
		home.clickMenuOption("Cultura");
		CulturaPage culturaPage = new CulturaPage(driver);

		assertTrue(culturaPage.checkMobileImage());
		assertTrue(culturaPage.getListSize() == 7);
	}
	
	
	@Test
	@DisplayName("Change language")
	@Tag("Language")
	public void languageText() {
		driver.get(URL_HOME);
		AuraHomePage home = new AuraHomePage(driver);
		if (home.cookiesPanel()) {
			home.clickAcceptCookies();
		}
				
		assertTrue(home.checkWelcomeTextEs());
		
		if (home.checkLanguageImage()) {
			home.clickLanguage();
		} else {
			System.out.println("Image not found");
		}	
		
		assertTrue(home.checkWelcomeTextEn());
		
	}
}
