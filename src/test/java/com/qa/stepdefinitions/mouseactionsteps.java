
package com.qa.stepdefinitions;

import com.qa.base.DriverFactory;
import com.qa.pages.MouseActionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.qa.utils.ConfigReader;
import org.testng.Assert;

public class mouseactionsteps {
  private MouseActionPage mouseActionPage;

    @Given("User is on the webpage")
    public void user_is_on_the_webpage() {
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
        mouseActionPage = new MouseActionPage(DriverFactory.getDriver());
    }

    @When("User hovers over the Pointme button")
    public void user_hovers_over_the_pointme_button() {
        mouseActionPage.hoverOverButton();
    }

    @Then("User clicks the mobiles button")
    public void user_clicks_the_mobiles_button() {
        mouseActionPage.clickMobilesButton();
    }

    @When("User clicks the file upload button")
    public void user_clicks_the_file_upload_button() {
        mouseActionPage.clickFileUploadButton();
    }

    @Then("User uploads a file")
    public void user_uploads_a_file() {
        mouseActionPage.uploadFile();
    }

       @When("User clicks the checkbox for {string}")
    public void user_clicks_the_checkbox_for_device(String device) {
        switch (device) {
            case "smartwatch":
                mouseActionPage.clickSmartwatchCheckbox();
                break;
            case "Television":
                mouseActionPage.clickTelevisionCheckbox(); 
                break;
            case "Soundbar":
                mouseActionPage.clickSoundbarCheckbox();
                break;
        }
    }

    @Then("User verifies that the {string} checkbox is selected")
    public void user_verifies_that_the_checkbox_is_selected(String device) {
        switch (device) {
            case "smartwatch":
                mouseActionPage.verifySmartwatchCheckboxSelected();
                break;
            // Add more cases as needed
        }
    }

     @When("User selects a {string} date from the date picker")
    public void user_selects_a_date_from_the_date_picker(String date) {
        mouseActionPage.selectDateFromDatePicker(date);
    }

    @Then("User verifies that the date displayed is correct")
    public void user_verifies_that_the_date_displayed_is_correct() {

    String actualDate = mouseActionPage.getSelectedDate();

    Assert.assertEquals(actualDate, "09/15/2026");
}





}
