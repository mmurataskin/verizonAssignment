package steps.apiSteps;

import modelsApi.Student;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utilities.apiRunner;

public class StudentEmail_steps {

    @When("user hits students API")
    public void user_hits_students_API() {
        apiRunner.runGet("http://cybertekchicago.com/student/all");
    }

    @Then("user verify email contains properly characters")
    public void user_verify_email_contains_properly_characters() {
        int counter = 0;
        for(Student student: apiRunner.getResponse().getStudents()){
            String email = student.getContact().getEmailAddress();
            System.out.println(email);
            Assert.assertTrue("Student email is failing at index: " + counter, email.contains("@") && email.contains("."));
            counter++;
        }
    }
}
