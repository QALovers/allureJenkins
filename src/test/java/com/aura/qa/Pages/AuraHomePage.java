package com.aura.qa.Pages;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aura.qa.util.TestFunctions;

public class AuraHomePage {
	
	WebDriver driver;
	public AuraHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
    @FindBy(xpath = "(//div[contains(@class,'row_1')]//div[@class='et_pb_text_inner']/p)[1]")
    WebElement tituloPagina;

    @FindBy(id = "catapultCookie")
    WebElement acceptCookies;

    private final String menuOptions = "//*[@id='top-menu-nav']//a[text()='%s']";
 
    @FindBy(xpath = "(//div[@class='et_pb_text_inner'])[1]/p")
    WebElement welcomeText;
    
    @FindBy(xpath = "(//img[@class='wpml-ls-flag'])[1]")
    WebElement changelanguage;

    @Step("Check if languege iamge is visible ")
    public boolean checkLanguageImage() {
    	return changelanguage.isDisplayed();
    }

    @Step("Change Language")
    public void clickLanguage() {
    	changelanguage.click();
    }
    
    public boolean checkWelcomeTextEs()
    {
    	return welcomeText.getText().contains("Predice");
    }
    
    public boolean checkWelcomeTextEn()
    {
    	return welcomeText.getText().contains("Predict");
    }
    
    @Step("Get header")
    public String getTitle() {
        return tituloPagina.getText();
    }
    
    @Step("Click menu option {0}")
    public void clickMenuOption(String option){
        WebElement element = driver.findElement(By.xpath(String.format(menuOptions, option)));
        element.click();
    }
    
    @Step("Accept cookies")
    public void clickAcceptCookies(){
        acceptCookies.click();
    }
    
    
    @Step ("Cookies panel displayed")
    public boolean cookiesPanel(){
        return acceptCookies.isDisplayed();
    }
}
