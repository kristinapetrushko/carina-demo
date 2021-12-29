package com.qaprosoft.carina.demo.gui.mypages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageDemo extends AbstractPage {

    @FindBy(className = "login_logo")
    private ExtendedWebElement title;

    @FindBy(id = "user-name")
    private ExtendedWebElement username;

    @FindBy(id = "password")
    private ExtendedWebElement password;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    public HomePageDemo(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return title.isElementPresent(5);
    }

    public WebElement getUsername() {
        return (WebElement) username;
    }

    public WebElement getPassword() {
        return (WebElement) password;
    }

    public WebElement getLoginButton() {
        return (WebElement) loginButton;
    }

    public InventoryPageDemo goToInventoryPage() {
        loginButton.click();
        return new InventoryPageDemo(getDriver());
    }
}

