package com.qaprosoft.carina.demo.gui.mypages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryPageDemo extends AbstractPage {

    public static final String inventoryURL = "https://www.saucedemo.com/inventory.html";

    @FindBy(className = "bm-burger-button")
    private ExtendedWebElement menuButton;

    public boolean isMenuButtonPresent() {
        return menuButton.isElementPresent();
    }

    public InventoryPageDemo(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
}
