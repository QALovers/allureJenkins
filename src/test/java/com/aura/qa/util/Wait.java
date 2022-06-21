package com.aura.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.function.Function;

public class Wait {

	private static void until(WebDriver webDriver, int timeOutInSeconds, Function<WebDriver, Boolean> waitCondition) {
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeOutInSeconds);
		try {
			webDriverWait.until(waitCondition);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void untilAjaxCallIsDone(WebDriver webDriver, int timeOutInSeconds) {
		until(webDriver, timeOutInSeconds, (function) -> {
			Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) webDriver)
					.executeScript("return jQuery.active==0");
			if (!isJqueryCallDone)
				System.out.println("jQuery call is in progress");
			return isJqueryCallDone;
		});
	}

	public static void untilPageReadyState(WebDriver webDriver, int timeOutInSeconds) {
		until(webDriver, timeOutInSeconds, (function) -> {
			String isPageLoaded = String
					.valueOf(((JavascriptExecutor) webDriver).executeScript("return document.readyState"));
			if (isPageLoaded.equals("complete")) {
				return true;
			} else {
				System.out.println("Document is loading");
				return false;
			}
		});
	}

	public static void untilElementIsVisible(WebDriver webDriver, WebElement webElement, Long timeOutInSeconds) {
		try {
			new WebDriverWait(webDriver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(webElement));
		} catch (TimeoutException e) {

		}
	}

	public static void untilElementIsNotVisible(WebDriver webDriver, WebElement webElement, Long timeOutInSeconds) {
		try {
			new WebDriverWait(webDriver, timeOutInSeconds).until(ExpectedConditions.invisibilityOf(webElement));
		} catch (TimeoutException e) {

		}
	}

	public static void untilListElementIsVisible(WebDriver webDriver, List<WebElement> webElements,
			Long timeOutInSeconds) {
		try {
			new WebDriverWait(webDriver, timeOutInSeconds)
					.until(ExpectedConditions.visibilityOfAllElements(webElements));
		} catch (TimeoutException e) {

		}
	}

	public static void untilElementIsEnabled(WebDriver webDriver, WebElement webElement, Long timeOutInSeconds) {
		try {
			new WebDriverWait(webDriver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (TimeoutException e) {

		}
	}


	public static void waitSeconds(int seconds) {
		if (seconds > 0) {
			try {
				Thread.sleep(seconds * 1000);
			} catch (InterruptedException e) {

			}
		}
	}

}
