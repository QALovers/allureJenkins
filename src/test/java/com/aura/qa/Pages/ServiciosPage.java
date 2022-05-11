package com.aura.qa.Pages;

import io.qameta.allure.Step;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aura.qa.util.TestFunctions;

public class ServiciosPage {

	WebDriver driver;

	public ServiciosPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	

	@FindBy(xpath = "//div[contains(@class,'et_pb_css_mix_blend_mode_passthrough')]//div[@class='et_pb_text_inner']/h3/parent::div")
	List<WebElement> images;

	@Step("Check cards")
	public int checkCards() {
		TestFunctions.await(driver);
		return images.size();
	}

}
