package com.object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_Page {

	public Cart_Page(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[text()='Shopping cart']")
	private WebElement shoppingCartHeading;
	
	@FindBy(xpath = "//a[text()='Blue Jeans' and @class='product-name']/ancestor::tr/descendant::input[@name='removefromcart']")
	private WebElement removeCheckBox;
	
	@FindBy(name = "updatecart")
	private WebElement updateShoppingCartButton;
	
	public WebElement getRemoveCheckBox() {
		return removeCheckBox;
	}

	public WebElement getUpdateShoppingCartButton() {
		return updateShoppingCartButton;
	}

	public WebElement getShoppingCartHeading() {
		return shoppingCartHeading;
	}
	
	
}
