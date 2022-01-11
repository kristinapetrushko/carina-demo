package com.qaprosoft.carina.demo.gui.mypages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryPageDemo extends AbstractPage {

    public static final String inventoryURL = "https://www.saucedemo.com/inventory.html";

    @FindBy(className = "bm-burger-button")
    private ExtendedWebElement menuButton;

    @FindBy(id = "item_4_img_link")
    private ExtendedWebElement productImage;

    @FindBy(className = "inventory_item_name")
    private ExtendedWebElement productName;

    @FindBy(className = "inventory_item_desc")
    private ExtendedWebElement productDescription;

    @FindBy(className = "inventory_item_price")
    private ExtendedWebElement productPrice;

    @FindBy(className = "btn btn_primary btn_small btn_inventory")
    private ExtendedWebElement addToCart;

    @FindBy(className = "product_sort_container")
    private ExtendedWebElement sortItem;

    public boolean isMenuButtonPresent() {
        return menuButton.isElementPresent();
    }

    public boolean isProductImagePresent() {
        return productImage.isElementPresent();
    }

    public String productName() {
        return productName.getText();
    }

    public boolean isProductDescriptionPresent() {
        return productDescription.isElementPresent();
    }

    public String productPrice() {
        return productPrice.getText();
    }

    public boolean isAddToCartPresent() {
        return addToCart.isElementPresent();
    }

    public boolean isSortItemPresent() {
        return sortItem.isElementPresent();
    }

    public InventoryPageDemo(WebDriver driver) {
        super(driver);
        setPageURL("/inventory.html");
    }

}
