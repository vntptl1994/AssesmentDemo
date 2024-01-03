package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By uname=By.id("user-name");
    private By pwd=By.id("password");
    private By btnlogin=By.id("login-button");
    private By message=By.xpath("//*[contains(text(),'Username and password do not match')]");
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getloginpagetitle(){
        return driver.getTitle();
    }
    public void entercredentials(String username,String password){
        driver.findElement(uname).sendKeys(username);
        driver.findElement(pwd).sendKeys(password);

    }
    public void clickonlogin(){
        driver.findElement(btnlogin).click();
    }
    public HomePage dologin(String username,String password){
        driver.findElement(uname).sendKeys(username);
        driver.findElement(pwd).sendKeys(password);
        driver.findElement(btnlogin).click();
        return new HomePage(driver);
    }
    public String geterrormessage(){
      String errormesssage=driver.findElement(message).getText();
      return errormesssage;
    }
}
