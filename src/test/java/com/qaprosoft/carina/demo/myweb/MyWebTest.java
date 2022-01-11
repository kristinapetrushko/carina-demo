package com.qaprosoft.carina.demo.myweb;

import com.itextpdf.text.log.LoggerFactory;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.mypages.HomePageDemo;
import com.qaprosoft.carina.demo.gui.mypages.InventoryPageDemo;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyWebTest implements IAbstractTest {
    HomePageDemo homePageDemo = new HomePageDemo(getDriver());
    private String correctUsername = "standard_user";
    private String correctPassword = "secret_sauce";
    private String incorrectUsername = "needhelp";
    private String incorrectPasword = "needhelp";

    @Test
    public void testHomeTitle() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isTitlePresent(), "Home page title isn`t present");
    }

    @Test
    public void testSuccessLogin() {
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page is not opened");
        homePageDemo.typeUsername(correctUsername);
        homePageDemo.typePassword(correctPassword);
        InventoryPageDemo inventoryPageDemo = homePageDemo.clickLoginBtn();
        Assert.assertTrue(inventoryPageDemo.isPageOpened(), "Inventory page is not opened");
        Assert.assertTrue(inventoryPageDemo.isMenuButtonPresent(), "Menu button is not present");
    }

    @Test
    public void testFailLogin() {
        final String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page is not opened");
        homePageDemo.typeUsername(incorrectUsername);
        homePageDemo.typePassword(incorrectPasword);
        homePageDemo.clickLoginBtn();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePageDemo.isErrorButtonPresent(), "There is no error button");
        Assert.assertTrue(homePageDemo.isErrorIconPresent(), "There is no error icon");
        String actualErrorMessage = homePageDemo.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect credentials");
    }

    @Test
    public void testElementsOnHomePage() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePageDemo.isUsernameFieldPresent(), "Username field is null");
        Assert.assertTrue(homePageDemo.isPasswordFieldPresent(), "Password field is null");
        Assert.assertTrue(homePageDemo.isLoginButtonPresent(), "Login button is null");
    }

    @Test
    public void testProductItemCard() {
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page is not opened");
        homePageDemo.typeUsername(correctUsername);
        homePageDemo.typePassword(correctPassword);
        InventoryPageDemo inventoryPageDemo = homePageDemo.clickLoginBtn();
        Assert.assertTrue(inventoryPageDemo.isPageOpened(), "Inventory page is not opened");
        Assert.assertTrue(inventoryPageDemo.isProductImagePresent(), "There is no product image");
        Assert.assertEquals(inventoryPageDemo.productName(), "Sauce Labs Backpack", "Incorrect product name");
        Assert.assertTrue(inventoryPageDemo.isProductDescriptionPresent(), "There is no product description");
        Assert.assertEquals(inventoryPageDemo.productPrice(), "$29.99", "Incorrect product price");
        Assert.assertTrue(inventoryPageDemo.isAddToCartPresent(), "There is no Add to cart");
    }

    @Test
    public void testDropDownFilterMenu() {
        homePageDemo.open();
        homePageDemo.typeUsername(correctUsername);
        homePageDemo.typePassword(correctPassword);
        InventoryPageDemo inventoryPageDemo = homePageDemo.clickLoginBtn();
        Assert.assertTrue(inventoryPageDemo.isPageOpened(), "Inventory page is not opened");

    }
}

