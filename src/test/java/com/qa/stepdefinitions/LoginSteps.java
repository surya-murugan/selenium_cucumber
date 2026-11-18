package com.qa.stepdefinitions;

import com.qa.base.DriverFactory;
import com.qa.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.qa.utils.ConfigReader;
import com.qa.pages.ProductsPage;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage;
 private ProductsPage productsPage;
    @Given("user is on the SauceDemo login page")
    public void user_is_on_the_sauce_demo_login_page() {

        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));

        loginPage = new LoginPage(DriverFactory.getDriver()); 
        
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
String username = ConfigReader.getProperty("username");
    String password = ConfigReader.getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {

        loginPage.clickLogin();
        productsPage = new ProductsPage(DriverFactory.getDriver());
    }

    @Then("user should be navigated to the products page")
    public void user_should_be_navigated_to_the_products_page() {

        Assert.assertTrue(
        productsPage.isProductsPageDisplayed()
);
    }
}