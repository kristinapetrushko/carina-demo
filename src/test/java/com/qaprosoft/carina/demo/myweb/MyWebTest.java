package com.qaprosoft.carina.demo.myweb;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.mypages.HomePageDemo;
import com.qaprosoft.carina.demo.gui.mypages.InventoryPageDemo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyWebTest implements IAbstractTest {

    private String username = "standard_user";
    private String password = "secret_sauce";

    @Test
    public void testHomeTitle() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isTitlePresent(), "Home page title isn`t present");
    }

    @Test
    public void testSuccessLogin() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.getUsername().sendKeys("standard_user");
        homePageDemo.getPassword().sendKeys("secret_sauce");
        InventoryPageDemo inventoryPageDemo = homePageDemo.goToInventoryPage();
        Assert.assertEquals(inventoryPageDemo.getDriver().getCurrentUrl(), InventoryPageDemo.inventoryURL);
    }

}

