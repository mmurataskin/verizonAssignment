package steps.apiSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utilities.apiRunner;



public class singleStudent_Steps {

    @When("user hits single student API with {string}")
    public void user_hits_single_student_API_with(String string) {
        apiRunner.runGet(string);
    }

    @Then("user tests for required attributes")
    public void user_tests_for_required_attributes() {

        System.out.println(apiRunner.getResponse().getFirstName());
        System.out.println(apiRunner.getResponse().getLastName());
        Assert.assertTrue(apiRunner.getResponse().getFirstName() != null);
        Assert.assertTrue(apiRunner.getResponse().getLastName() != null);
        Assert.assertTrue(apiRunner.getResponse().getContact().getEmailAddress() != null);
        Assert.assertTrue(apiRunner.getResponse().getCompany().getAddress().getCity() != null);


    }

}