package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutFormPage {
    By fname=By.xpath("//*[@id=\"first-name\"]");
    By lname=By.xpath("//*[@id=\"last-name\"]");
    By postcode=By.xpath("//*[@id=\"postal-code\"]");
    By btncontinue=By.xpath("//*[@id=\"continue\"]");

    WebDriver driver;
    public CheckoutFormPage(WebDriver driver){
        this.driver=driver;
    }

    public void entercheckoutdetails(String firstname,String lastname,String postalcode){
        driver.findElement(fname).sendKeys(firstname);
        driver.findElement(lname).sendKeys(lastname);
        driver.findElement(postcode).sendKeys(postalcode);
    }
    public FinalcheckoutPage clickoncontinue(){
        driver.findElement(btncontinue).click();
        return new FinalcheckoutPage(driver);

    }
}
