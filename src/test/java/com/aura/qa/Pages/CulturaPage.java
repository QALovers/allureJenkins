package com.aura.qa.Pages;

import io.qameta.allure.Step;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aura.qa.util.TestFunctions;

public class CulturaPage {

	WebDriver driver;

	public CulturaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

    @FindBy(xpath = "//span[@class='et_pb_image_wrap ']//img")
    WebElement mobileImage;
    
    @FindBy(xpath = "(//div[@class='et_pb_text_inner'])[3]//ul//li")
    List<WebElement> listElement;
    
    @Step("Check if mobile image is visible")
	public boolean checkMobileImage() {
		return mobileImage.isDisplayed();
	}
    
    @Step("Return the number of elements of the list")
    public int getListSize() {
    	return listElement.size();
    }


}
