package com.aura.qa.Pages;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aura.qa.util.TestFunctions;

public class ContactoPage {
	
	WebDriver driver;
	
	public ContactoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
    @FindBy(xpath = "//button[contains(@class,'submit')]")
    WebElement sendButton;
    
    @FindBy(xpath = "//img[@class='wpml-ls-flag'][@alt='Inglés'][1]")
    WebElement langIcon;


    private final String formFields = "//*[contains(@placeholder,'%s')]";
 
    @Step("Check Send Button is displayed")
    public boolean checkSendButtonIsDisplayed(){
        return sendButton.isDisplayed();
    }
    
    @Step("Write {1} on field {0}")
    public void writeOnField(String field, String text){
        WebElement element = driver.findElement(By.xpath(String.format(formFields, field)));
        element.sendKeys(text);
    }
    
    @Step("Click english flag")
    public void clickEnglishFlag(){
    	langIcon.click();
    }
   
}
