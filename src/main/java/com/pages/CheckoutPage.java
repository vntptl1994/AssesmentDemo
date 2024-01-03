package com.pages;

import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;
    By btncheckout=By.xpath("//*[@id=\"checkout\"]");

    public CheckoutPage(WebDriver driver){
        this.driver=driver;

    }
    public CheckoutFormPage clickoncheckout(){
        driver.findElement(btncheckout).click();
        return new CheckoutFormPage(driver);
    }
}
