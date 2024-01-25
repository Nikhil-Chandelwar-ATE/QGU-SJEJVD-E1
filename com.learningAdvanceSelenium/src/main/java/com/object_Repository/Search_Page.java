package com.object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Page {

	public Search_Page(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Search']")
	private WebElement searchHeading;

	public WebElement getSearchHeading() {
		return searchHeading;
	}

}
