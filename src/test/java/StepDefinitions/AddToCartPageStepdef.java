package StepDefinitions;

import com.pages.*;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class AddToCartPageStepdef {
    private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
    private HomePage homePage=new HomePage(DriverFactory.getDriver());
    private CheckoutPage checkoutPage=new CheckoutPage(DriverFactory.getDriver());
    private CheckoutFormPage checkoutFormPage=new CheckoutFormPage(DriverFactory.getDriver());
    private FinalcheckoutPage finalcheckoutPage=new FinalcheckoutPage(DriverFactory.getDriver());
    private ThankYouPage thankYouPage=new ThankYouPage(DriverFactory.getDriver());
    @Given("User is already on logged in to application")
    public void userIsAlreadyOnLoggedInToApplication(DataTable dataTable) {
        List<Map<String,String>> credlist=dataTable.asMaps();
        String username=credlist.get(0).get("username");
        String password=credlist.get(0).get("password");
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
        homePage=loginPage.dologin(username,password);
    }
    @Given("User is on home page")
    public void userIsOnHomePage() {
        homePage.gettitle();
    }

    @Given("click on add to cart button")
    public void clickOnAddToCartButton()  {
        homePage.clickonaddtocart();
    }
    @And("click on cart image")
    public void clickOnCartImage() {
        checkoutPage=homePage.clickoncart();
    }
    @When("user clicks on checkout button")
    public void userClicksOnCheckoutButton() {
        checkoutFormPage=checkoutPage.clickoncheckout();
    }

    @When("user enters {string} {string} and {string}")
    public void userEntersAnd(String firstname, String lastname, String postalcode) {
        checkoutFormPage.entercheckoutdetails(firstname,lastname,postalcode);
    }
    @Then("user clicks on continue")
    public void userClicksOnContinue() {
        finalcheckoutPage=checkoutFormPage.clickoncontinue();
    }
    @When("user clicks on finish button")
    public void userClicksOnFinishButton() {
        thankYouPage= finalcheckoutPage.clickonfinish();
    }



    @Then("message should be displayed {string}")
    public void messageShouldBeDisplayed(String expectedmessage) {
        String message= thankYouPage.getthankyoumessage();
        Assert.assertTrue(message.contains(expectedmessage));
    }


}
