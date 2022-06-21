
package com.aura.qa.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.script.ScriptException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aura.qa.Constants;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class TestFunctions {


	 private static Logger logger = LoggerFactory.getLogger(TestFunctions.class);  
	
	public static void setTimeOut(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
	}

	public static WebDriver configureDriver(String name) {
		
		
		String operatingSystem=System.getProperty("os.name");
				
		logger.info(operatingSystem);
		
		logger.info("Driver: "+name);
		
		WebDriver driver = null;
		
		String driverPath="";
		if (name.toLowerCase().contains(Constants.CHROME)) {
			ChromeOptions options = new ChromeOptions();
			if (Constants.HEADLESS) {
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
			}
			if (operatingSystem.toLowerCase().contains(Constants.WINDOWS))
			{			
				driverPath=Constants.CHROME_DRIVER_PATH+Constants.EXTENSION_WINDOWS;
				System.setProperty(Constants.WEBDRIVER_CHROME_DRIVER, driverPath);
			} else {
				driverPath=Constants.CHROME_DRIVER_PATH;
				System.setProperty(Constants.WEBDRIVER_CHROME_DRIVER, driverPath);
			}
			driver = new ChromeDriver(options);
		}
		if (name.toLowerCase().contains(Constants.FIREFOX)) {
			
			FirefoxOptions options = new FirefoxOptions();
			//Esta linea se utiliza para que no levante firefox (evitar entorno grafico)
			if (Constants.HEADLESS) {
				options.addArguments("--headless");
			}
			//Fijamos idioma por defecto del navegador para que coincida con el nuestro
			options.addArguments("--lang=es-ES");
			options.addPreference("intl.accept_languages", "es-ES");
			if (operatingSystem.toLowerCase().contains(Constants.WINDOWS))
			{
				driverPath=Constants.GECKO_DRIVER_PATH+Constants.EXTENSION_WINDOWS;
				System.setProperty(Constants.WEBDRIVER_GECKO_DRIVER, driverPath);
				driver = new FirefoxDriver(options);				
			}else {
				driverPath=Constants.GECKO_DRIVER_PATH;				
				System.setProperty(Constants.WEBDRIVER_GECKO_DRIVER, driverPath);

				driver = new FirefoxDriver(options);
			}	
		}
		
		driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);

		return driver;
	}

	public static void loadConfiguration() throws IOException, FileNotFoundException {
		Properties p = new Properties();
		p.load(new FileReader(Constants.TEST_CONFIG_PATH));

		String navegador = (String) p.get(Constants.CONFIG_NAVEGADOR);
		Constants.DRIVER_SELECTED = navegador;

		String timeout = (String) p.get(Constants.CONFIG_TIMEOUT);
		Constants.TIMEOUT = Integer.parseInt(timeout);
		
		String head = (String) p.get(Constants.CONFIG_HEADLESS);
		Constants.HEADLESS = Boolean.parseBoolean(head);
	}

	public static void sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			System.out.println("Error in sleep");
			e.printStackTrace();
		}
	}

	public static double evalOpp(String operation) throws ScriptException {

		Expression expression = new ExpressionBuilder(operation).build();
		return expression.evaluate();

	}
	
	


	public static void main(String[] args) {
		
		System.out.println(System.getProperty("os.name"));
		
		
	}

}
