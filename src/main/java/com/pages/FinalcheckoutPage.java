package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalcheckoutPage {
    WebDriver driver;
    By btnfinish=By.xpath("//*[@id=\"finish\"]");
    public FinalcheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    public ThankYouPage clickonfinish(){
        driver.findElement(btnfinish).click();
        return new ThankYouPage(driver);
    }

}
