package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By btn_addtocart=By.xpath("//button[text()='Add to cart']");
    By img_cart=By.xpath("//*[@id=\"shopping_cart_container\"]");
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }
    public String gettitle(){
       return driver.getTitle();
    }
   public void clickonaddtocart()  {
       driver.findElement(btn_addtocart).click();

   }
   public CheckoutPage clickoncart(){
        driver.findElement(img_cart).click();
        return new CheckoutPage(driver);
   }


}
