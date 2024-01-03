package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage {
    WebDriver driver;
    By msgthankyou=By.xpath("//div[@id='checkout_complete_container']//h2");
    public ThankYouPage(WebDriver driver){
        this.driver=driver;
    }

    public String getthankyoumessage(){
        String message=driver.findElement(msgthankyou).getText();
        return message;
    }
}
