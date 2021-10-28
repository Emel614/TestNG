package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DefaultPage {
    public  DefaultPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addUserButton;

    @FindBy(xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagementTab;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsTab;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListTab;

    @FindBy(id = "lkpGroups")
    public WebElement selectHotelType;

    @FindBy(xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButton;

    @FindBy(xpath = "//tbody//tr//td[7]")
    public WebElement hotelTypeColumn;

    @FindBy(xpath = "//button[@class='btn btn-sm red filter-cancel']")
    public WebElement clearButton;

    @FindBy(xpath = "//h3[@class='page-title']")
    public WebElement date;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "(//select[@name='datatable_ajax_length'])[1]")
    public WebElement defaultViewRecord;

    @FindBy(xpath = "(//a[@class='btn btn-sm default next'])[1]")
    public WebElement pageSymbol;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement pageNumber;

    @FindBy(xpath = "//button[@class='btn btn-sm yellow']")
    public WebElement downloadButton;

    @FindBy(xpath = "(//a[@target='_blank'])[1]")
    public WebElement detailsButton;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement editHotelText;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeInputText;

    @FindBy(xpath = "(//button[@class='btn green'])[1]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement hotelUpdatedSuccessfully;

    @FindBy(xpath = "(//a[@data-toggle='tab'])[3]")
    public WebElement propertiesButton;

    @FindBy(xpath = "//input[@id='product_barcodeCode_84']")
    public WebElement propertiesCodeText;

    @FindBy(xpath = "(//a[@class='btn default btn-sm'])[1]")
    public WebElement updateButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement valueUpdatedText;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement valueUpdateOKButton;

    @FindBy(xpath = "(//button[@class='btn blue'])[2]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement approvalMessage;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement approvalMessageOKButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement errorText;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement userID;

}
