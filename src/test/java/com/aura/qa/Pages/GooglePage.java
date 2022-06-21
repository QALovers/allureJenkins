package com.aura.qa.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	
	WebDriver driver;

	public GooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath="(//div//button)[4]")
	private WebElement acceptButton;
	
	@FindBy(xpath="//img[@alt='Google']")
	private WebElement googleImage;
	
	
	
	
	public void clickAcceptButton()
	{	
		acceptButton.click();
	}

	
	public boolean checkGoogleImage()
	{
		return googleImage.isDisplayed();
	}
	
	
}
