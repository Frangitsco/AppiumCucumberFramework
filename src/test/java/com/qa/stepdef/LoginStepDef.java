package com.qa.stepdef;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepDef {

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("I login")
    public void iLogin() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("login should fail with an error {string}")
    public void loginShouldFailWithAnError(String err) {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("I should see Products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String title) {
        // Write code here that turns the phrase above into concrete actions
    }

}


