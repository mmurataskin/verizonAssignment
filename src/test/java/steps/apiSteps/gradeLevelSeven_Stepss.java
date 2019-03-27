package steps.apiSteps;

import modelsApi.Student;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.apiRunner;

import java.util.List;

public class gradeLevelSeven_Stepss {

    @When("user hits students API {string}")
    public void user_hits_students_API(String string) {
        apiRunner.runGet(string);

    }

    @Then("user verifies each Student in batch seven")
    public void user_verifies_each_Student_in_batch_seven() {
        List<Student> students = apiRunner.getResponse().getStudents();
        for (Student student : students) {
            if (student.getGradeLevel() == 7) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        }
    }

}
