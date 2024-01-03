package StepDefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepsdef {
    private String title;
    private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
    @Given("user is on login page")
    public void userIsOnLoginPage() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }


    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expectedtitle) {
        Assert.assertTrue(title.contains(expectedtitle));

    }

    @When("User enters {string} and {string}")
    public void userEntersAnd(String username, String password) {
     loginPage.entercredentials(username,password);
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        loginPage.clickonlogin();
    }

    @When("user gets title of page")
    public void userGetsTitleOfPage() {
        title=loginPage.getloginpagetitle();
    }

    @Then("user should get error message {string}")
    public void userShouldGetErrorMessage(String errormessage) {
       String actualerrormsg= loginPage.geterrormessage();
       Assert.assertTrue(actualerrormsg.contains(errormessage));
    }
}
