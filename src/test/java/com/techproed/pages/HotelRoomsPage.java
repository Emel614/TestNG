package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomsPage {
    public HotelRoomsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoomTab;

    @FindBy(id = "IDHotel")
    public WebElement idDropDown;

    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='Location']")
    public WebElement location;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement textarea;

    @FindBy(xpath = "(//a[@href='#'])[2]")
    public WebElement price;

    @FindBy(xpath = "//input[@id='Price']")
    public WebElement priceBox;

   @FindBy(id = "IDGroupRoomType")
    public WebElement roomType;

   @FindBy(id = "MaxAdultCount")
    public WebElement adult;

   @FindBy(id = "MaxChildCount")
    public WebElement child;

   @FindBy(id = "IsAvailable")
    public WebElement approve;

   @FindBy(id = "btnSubmit")
    public WebElement submit;

    @FindBy(xpath = "//div[.='HotelRoom was inserted successfully']")
    public WebElement text;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement okButton;

}

