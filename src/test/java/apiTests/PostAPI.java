package apiTests;

import modelsApi.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.apiRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class PostAPI {

    @Test
    public void postProfessor() {
        Professor professor = new Professor();
        professor.setFirstName("Connor");
        professor.setLastName("Sarah");
        professor.setSubject("Advanced");
        professor.setGradeLevel(10);

        Response response = RestAssured.given().contentType(ContentType.JSON).body(professor).when().post("http://................");
        System.out.println(response.statusCode());
        System.out.println(response.asString());


    }

    @Test
    public void customSingleStudent() throws IOException {
        Response response = RestAssured.get("http://.............................");
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse cr = mapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(cr.getFirstName());
        System.out.println(cr.getLastName());
        System.out.println(cr.getContact().getEmailAddress());

    }

    @Test
    public void listOfProfessors() throws IOException {
        Response response = RestAssured.get("http://..........................");
        System.out.println(response.statusCode());
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse cr = mapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(cr.getProfessors().get(0).getSubject());


    }

    @Test
    public void listOfInstructorsTest() throws IOException {

        Response response = RestAssured.get("http://..............................");
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse cr = mapper.readValue(response.asString(), CustomResponse.class);

        for (int i = 0; i < cr.getProfessors().size(); i++) {
            if (cr.getProfessors().get(i).getSubject() == null) {
                System.out.println(cr.getProfessors().get(i).getFirstName());
            }
        }

    }

    @Test
    public void studentLocation() throws IOException {
        Response response = RestAssured.get("http://............................");
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse cr = mapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(cr.getStudents().size());
        int counter = 0;
        for (Student student : cr.getStudents()) {
            if (student.getCompany().getAddress().getCity().equalsIgnoreCase("New Jersey")) {
                System.out.println(student.getFirstName());
                counter++;
            }
        }
        System.out.println("Total: " + counter);

    }

    @Test
    public void customResponse() {
        apiRunner.runGet("http://................................");
        String str = apiRunner.getResponse().getProfessors().get(0).getFirstName();
        Assert.assertEquals("Jack", str);


    }

    @Test
    public void OscarTest() {
        apiRunner.runGet("http://..................................");
        for (Professor each : apiRunner.getResponse().getProfessors()) {
            if (each.getId() == 15) {
                System.out.println(each.getFirstName() + " " + each.getLastName());
            }
        }
    }

    @Test
    public void OscarTestRevise() {
        apiRunner.runGet("http://...................................");
        apiRunner.getResponse().getProfessors()
                .stream()
                .forEach(each -> {
                    if (each.getId() == 15) {
                        System.out.println(each.getFirstName() + " " + each.getLastName());
                    }
                });
    }

    @Test
    public void OscarTest2() {
        apiRunner.runGet("http://.........................................");
        for (Professor each : apiRunner.getResponse().getProfessors()) {
            if (each.getSubject() != null && each.getSubject().equalsIgnoreCase("Intro to Java programming")) {
                System.out.println(each.getLastName());

            }
        }

    }

    @Test
    public void OscarTest2Revise() {

        apiRunner.runGet("http://............................................");
        List<Professor> instructors = apiRunner.getResponse().getProfessors()
                .stream()
                .filter(each -> each.getSubject() != null && each.getSubject().equalsIgnoreCase("Intro to Java programming"))
                .collect(Collectors.toList());


    }

    @Test
    public void OscarTest3() {
        apiRunner.runGet("http://..................................................");
        List<String> myList = new ArrayList<>();
        myList.add("Ma");
        myList.add("Akmt");
        myList.add("Akmt");
        myList.add("Bean");
        myList.add("Williams");
        myList.add("bb");
        List<String> ins = new ArrayList<>();
        for (Professor each : apiRunner.getResponse().getProfessors()) {
            if (each.getSubject() != null && each.getSubject().equalsIgnoreCase("Intro to Java programming")) {
                ins.add(each.getLastName());
            }
        }

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).equalsIgnoreCase(ins.get(i))) {
                System.out.println("passed");
            }
        }
    }


    @Test
    public void OscarTest3Revise() {
        apiRunner.runGet("http://................................");
        List<String> myList = new ArrayList<>();
        myList.add("Ma");
        myList.add("Akmt");
        myList.add("Akmt");
        myList.add("Bean");
        myList.add("Williams");
        myList.add("bb");
        myList.add("aaa");

        List<Professor> actualInstructors = apiRunner.getResponse().getProfessors();

        myList.stream().forEach(expected -> {
            boolean exists = actualInstructors
                    .stream()
                    .filter(each -> each.getSubject() != null && each.getSubject().equalsIgnoreCase("Intro to Java programming"))
                    .filter(name -> name.getLastName().equalsIgnoreCase(expected))
                    .findAny()
                    .isPresent();
            Assert.assertTrue("does not exist", exists);
        });

    }

    @Test
    public void utilTest(){
        apiRunner.runGet("http://..................................");
        String companyLocation = apiRunner.getResponse().getCompany().getAddress().getCity();
        System.out.println(companyLocation);
    }

    @Test
    public void Batch7Test(){
        apiRunner.runGet("http://....................................");
        List<Student> batches = apiRunner.getResponse().getStudents();
        for(Student batch : batches){
            if(batch.getGradeLevel() == 7){
                System.out.println(batch.getFirstName() + " " + batch.getLastName());
            }

        }
    }

    @Test
    public void OscarTest3ReviseGit() {
        apiRunner.runGet("http:..................................");
        List<String> myList = new ArrayList<>();
        myList.add("Ma");
        myList.add("Akmt");
        myList.add("Akmt");
        myList.add("Bean");
        myList.add("Williams");
        myList.add("bb");
        myList.add("aaa");

        List<Professor> actualProfessors = apiRunner.getResponse().getProfessors();

        myList.stream().forEach(expected -> {
            boolean exists = actualProfessors
                    .stream()
                    .filter(each -> each.getSubject() != null && each.getSubject().equalsIgnoreCase("Intro to Java programming"))
                    .filter(name -> name.getLastName().equalsIgnoreCase(expected))
                    .findAny()
                    .isPresent();
            Assert.assertTrue("does not exist", exists);
        });

        System.out.println("GIT TEST");
    }

    @Test
    public void postTest(){

        Professor professor = new Professor();
        professor.setSubject("JAVA");
        professor.setGradeLevel(10);
        professor.setFirstName("Murat");
        professor.setLastName("Taskin");

        for(int i = 0; i < 10; i++) {

            Response response = RestAssured.given().contentType(ContentType.JSON).
                    body(professor).post("http://");

        }


        System.out.println("new things");
    }

}