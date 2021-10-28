package com.techproed.tests.smoketest;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Create a clickOnLogin method
//Click on Hotel Management
//Click on Hotel Rooms
//Click on Add Hotel Room
//Enter All required fields
//To enter a price, we can send keys, OR we can use actions class to drag and drop
//Click Save
//Verify the message: HotelRoom was inserted successfully
//Click OK
public class Day12_HotelRoomCreation {
    LoginPage loginPage;
    DefaultPage defaultPage;
    HotelRoomsPage hotelRoomsPage;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage = new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();

        defaultPage = new DefaultPage();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
    }
    @Test
    public void hotelRoomCreate() throws InterruptedException {
        defaultPage.hotelManagementTab.click();

        defaultPage.hotelRoomsTab.click();

        hotelRoomsPage = new HotelRoomsPage();
        hotelRoomsPage.addHotelRoomTab.click();

        Select select = new Select(hotelRoomsPage.idDropDown);
        select.selectByIndex(2);

        hotelRoomsPage.code.sendKeys("discount code");

        hotelRoomsPage.name.sendKeys("Ali Can");

        hotelRoomsPage.location.sendKeys("USA");

        hotelRoomsPage.textarea.sendKeys("Hello");

        //hotelRoomsPage.priceBox.sendKeys("200");
        Thread.sleep(3000);
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(hotelRoomsPage.price,hotelRoomsPage.priceBox).perform();

        Select select1 = new Select(hotelRoomsPage.roomType);
        select1.selectByIndex(1);

        hotelRoomsPage.adult.sendKeys("2");

        hotelRoomsPage.child.sendKeys("1");

        hotelRoomsPage.approve.click();

        hotelRoomsPage.submit.click();

        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement message = wait.until(ExpectedConditions.visibilityOf(hotelRoomsPage.text));
        Assert.assertTrue(message.isDisplayed());

        hotelRoomsPage.okButton.click();


    }

}
