package apiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.json.Json;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.Map;

public class CMStudent {


    @Test
    public void studentList() {
        Response response = RestAssured.get("http://.........................");//returns responses
        System.out.println(response.statusCode());//status code of this api code
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.toString());// gives responses as String
        List object = response.getBody().as(List.class);

        List<Map<String, Object>> all = response.getBody().as(List.class);
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i).get("id") + " - " + all.get(i).get("firstName") + " - " + all.get(i).get("lastName") + " - " + all.get(i).get("gradeLevel") + " - " + all.get(i).get("subject"));
        }

    }

    @Test
    public void task() {

        Response response = RestAssured.get("http://............................");
        System.out.println(response.statusCode());
        System.out.println(response.toString());
        JsonPath jp = response.jsonPath();
        int b = jp.get("gradeLevel");
        System.out.println(b);

        String email = jp.get("contact.emailAddress");
        System.out.println(email);

        String address = jp.getString("company.address.street");
        System.out.println(address);

    }

    @Test
    public void listOfInstructors() {
        Response response = RestAssured.get("http://...........................");
        List<Map<String, Object>> instructors = response.getBody().as(List.class);
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).get("id") != null)

                System.out.println(instructors.get(i).get("id") + " - " + instructors.get(i).get("firstName") + " - " + instructors.get(i).get("lastName") + " - " + instructors.get(i).get("gradeLevel") + " - " + instructors.get(i).get("subject"));
        }
        //JSON PATH

        JsonPath jp = response.jsonPath();
        List<String> subjects = jp.get("subject");
        System.out.println("Size of Subjects: " + subjects.size());
        for (String each : subjects) {
            System.out.println(each.isEmpty());
        }


    }

}