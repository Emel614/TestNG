package com.techproed.tests;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day13_WebTables {
    LoginPage loginPage;
    DefaultPage defaultPage;
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();

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

        defaultPage.hotelManagementTab.click();

        defaultPage.hotelRoomsTab.click();

    }
    /*
Create a test method: entireTable() and Find the size of the entire table body and print all of headers
Create a test method: printRows() and Print all of the rows and print the element s on the 4th row
Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column
     */
    @Test
    public void entireTable(){
        System.out.println("*Entire Table*");
        WebElement tableBody = Driver.getDriver().findElement(By.xpath("//table//tbody"));
        System.out.println(tableBody.getText());

        List<WebElement> tableHeaders = Driver.getDriver().findElements(By.xpath("//th"));

        for(WebElement each: tableHeaders){
            System.out.println(each.getText());
        }
    }
    @Test
    public void printRows(){
        System.out.println("Print Rows");

        List<WebElement> tableRows = Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));
        int rowNum = 1;
        for(WebElement each: tableRows){
            System.out.println("Row Number "+rowNum + " => "+each.getText());
            rowNum++;
        }
        WebElement fourthRow = Driver.getDriver().findElement(By.xpath("//table//tbody//tr[4]"));
        System.out.println(fourthRow.getText());
    }
    @Test
    public void printCells(){
        System.out.println("Print Cells");

        List<WebElement> tableCells = Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td"));
        System.out.println("Total Cell Numbers ==> "+ tableCells.size());
        int celNum = 1;
        for(WebElement each : tableCells){
            System.out.println(celNum +" : "+each.getText());
            celNum++;
        }
    }
    @Test
    public void printColumns(){
        System.out.println("Print Columns");
        List<WebElement> tableColumns = Driver.getDriver().findElements(By.xpath("//th"));
        System.out.println("Number of columns are = "+tableColumns.size());

        List<WebElement> column5 = Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td[5]"));
        int columnNum = 1;
        for(WebElement each : column5){
            System.out.println(columnNum+":"+each.getText());
            columnNum++;
        }
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
