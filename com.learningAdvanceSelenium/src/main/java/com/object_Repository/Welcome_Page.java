package com.object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcome_Page {

	public Welcome_Page(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log in")
	private WebElement loginLink;

	@FindBy(linkText = "Shopping cart")
	private WebElement shoppingCartLink;

	@FindBy(name = "q")
	private WebElement searchTextField;

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}
}
