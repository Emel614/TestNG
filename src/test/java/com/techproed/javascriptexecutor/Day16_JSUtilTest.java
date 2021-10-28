package com.techproed.javascriptexecutor;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSUtils;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_JSUtilTest {
    @Test
    public void scrollIntoView(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement resentBlog = Driver.getDriver().findElement(By.xpath("//*[.='Recent Blog']"));
        JSUtils.scrollIntoViewJS(resentBlog);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(resentBlog.getText(),"Recent Blog");
    }
    @Test
    public void clickWithJS(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailability = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.clickElementByJS(checkAvailability);
    }
    @Test
    public void flashJS(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailability = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.flash(checkAvailability);
    }
    @Test
    public void changeColorJS(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.changeColor("red",checkAvailabilityButton);
    }
}
