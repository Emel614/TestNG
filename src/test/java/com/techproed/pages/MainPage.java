package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    Create a package: smoketest
    Create a class: PositiveTest
    Method: positiveLoginTest
    When user goes to http://www.carettahotel.com/
    And click on Log in
    And send the username and password
    Manager
    Manager1!
 */
public class MainPage {
    public MainPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement mainPageLoginLink;



}
