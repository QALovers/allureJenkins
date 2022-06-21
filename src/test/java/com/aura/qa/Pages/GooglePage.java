package com.aura.qa.Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aura.qa.util.Wait;

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
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement searchBox;
	
	@FindBy(xpath="//div[@data-header-feature]")
	private List<WebElement> resultList;
	
	public void clickAcceptButton()
	{	
		acceptButton.click();
	}
	
	public boolean checkGoogleImage()
	{
		return googleImage.isDisplayed();
	}
	
	public void searchText(String textToSearch)
	{
		searchBox.sendKeys(Keys.CONTROL+"A");
		searchBox.sendKeys(Keys.BACK_SPACE);
		searchBox.sendKeys(textToSearch);
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public boolean checkResults()
	{
		Wait.waitSeconds(2);
		int numResults=resultList.size();
		System.out.println("Search results: "+numResults);
		return numResults>0;
	}
}