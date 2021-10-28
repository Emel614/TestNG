package com.techproed.tests;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Set;

public class Homework {
    LoginPage loginPage;
    DefaultPage defaultPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        loginPage = new LoginPage();
        defaultPage = new DefaultPage();
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        Thread.sleep(1000);
        //if (loginPage.advancedLink.isDisplayed()){
            try{
                Thread.sleep(1000);
                loginPage.advancedLink.click();
                Thread.sleep(1000);
                loginPage.proceedLink.click();
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Advanced Link and Proceed Link is not displayed");
            }
        //}

        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        defaultPage.hotelManagementTab.click();
        defaultPage.hotelListTab.click();

    }
    @Test(priority = 1)
    public void hotelTypeTest() throws InterruptedException {
        Select select = new Select(defaultPage.selectHotelType);
        select.selectByVisibleText("Hotel Type1");
        defaultPage.searchButton.click();
        Thread.sleep(2000);
        Assert.assertFalse(defaultPage.hotelTypeColumn.getText().contains("Hotel Type2"));

        select.selectByVisibleText("Hotel Type2");
        defaultPage.searchButton.click();
        Thread.sleep(2000);
        Assert.assertFalse(defaultPage.hotelTypeColumn.getText().contains("Hotel Type1"));

        defaultPage.clearButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(defaultPage.hotelTypeColumn.getText().contains("Hotel Type1") || defaultPage.hotelTypeColumn.getText().contains("Hotel Type2"));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate localDate = LocalDate.now();
        String expectedDate = dateTimeFormatter.format(localDate);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(defaultPage.date.getText().equals(expectedDate));

        int expectedRowSize = 10;
        softAssert.assertEquals(defaultPage.tableRows.size(), expectedRowSize);
        select = new Select(defaultPage.defaultViewRecord);
        select.selectByVisibleText("20");
        Thread.sleep(2000);
        softAssert.assertEquals(defaultPage.tableRows.size(), 20);

        defaultPage.pageSymbol.click();
        Thread.sleep(2000);
        softAssert.assertEquals(defaultPage.pageNumber.getAttribute("value"),"2");
        System.out.println(defaultPage.pageNumber.getAttribute("value"));
        softAssert.assertAll();
    }
    @Test(priority = 2)
    public void downloadPage() throws InterruptedException {
        defaultPage.downloadButton.click();
        String path = System.getProperty("user.home");
        String excelPath = path+ "\\Downloads\\Admin - List Of Hotels.xlsx";
        Thread.sleep(3000);
        Boolean isFileExist = Files.exists(Paths.get(excelPath));
        Assert.assertTrue(isFileExist);
    }
    @Test(priority = 3)
    public void editPageTest() throws InterruptedException {
        defaultPage.detailsButton.click();
        String firstWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        String secondWindow = "";
        for(String each: allWindows){
            if(!each.equals(firstWindow)){
                secondWindow = each;
            }
        }
        Thread.sleep(2000);
        Driver.getDriver().switchTo().window(secondWindow);
        Thread.sleep(2000);
        Assert.assertTrue(defaultPage.editHotelText.getText().contains("Edit Hotel"));

    }
    @Test(priority = 4)
    public void editHotelCodeTest1() throws InterruptedException {
        editPageTest();
        defaultPage.codeInputText.clear();
        defaultPage.codeInputText.sendKeys("1234");
        defaultPage.saveButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(defaultPage.hotelUpdatedSuccessfully.isDisplayed());
    }
    @Test(priority = 5)
    public void editHotelCodeTest2() throws InterruptedException {
        editPageTest();
        defaultPage.propertiesButton.click();
        defaultPage.propertiesCodeText.clear();
        defaultPage.propertiesCodeText.sendKeys("3456");
        defaultPage.updateButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(defaultPage.valueUpdatedText.isDisplayed());
        defaultPage.valueUpdateOKButton.click();
        defaultPage.deleteButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(defaultPage.approvalMessage.isDisplayed());
        defaultPage.approvalMessageOKButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(defaultPage.errorText.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}