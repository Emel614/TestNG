package com.techproed.tests.smoketest;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day12_PositiveTest {
    @Test
    public void positiveLoginTest(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        MainPage mainPage = new MainPage();//for page 1
        mainPage.mainPageLoginLink.click();

        LoginPage loginPage = new LoginPage();//for page 2
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();

        DefaultPage defaultPage = new DefaultPage();
        boolean isLoggedIn = defaultPage.addUserButton.isDisplayed();
        Assert.assertTrue(isLoggedIn);

    }
}
