package com.techproed.tests;

import com.techproed.pages.TestAddressLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class Day12_TestAddressLoginTest {
    @Test
    public void testAddressLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("test_address_url"));

        TestAddressLoginPage testAddressLoginPage = new TestAddressLoginPage();
        testAddressLoginPage.email.sendKeys(ConfigReader.getProperty("test_address_email"));
        testAddressLoginPage.password.sendKeys(ConfigReader.getProperty("test_address_password"));
        testAddressLoginPage.singInButton.click();
        Driver.closeDriver();

    }
}
