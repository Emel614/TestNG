package com.techproed.tests.smoketest;

import com.techproed.pages.LoginPage;
import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day12_NegativeTest {
    @Test
    public void invalidLoginTest() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        loginPage.password.sendKeys(ConfigReader.getProperty("wrong_manager_password"));
        loginPage.loginButton.click();

        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains("Wrong password"));

        Driver.closeDriver();
    }
    @Test
    public void invalidId(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("wrong_manager_username"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();

        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains("Try again please"));

        Driver.closeDriver();
    }
    @Test
    public void invalidIdPassword(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("wrong_manager_username"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        loginPage.password.sendKeys(ConfigReader.getProperty("wrong_manager_password"));
        loginPage.loginButton.click();

        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains("Username or password is incorrect, please correct them and try again"));
        Driver.closeDriver();
    }
}