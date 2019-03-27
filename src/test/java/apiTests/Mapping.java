package apiTests;

import modelsApi.Professor;
import modelsApi.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;

public class Mapping {

    @Test
    public void pojoMapping() throws IOException {

        // One JSON FORMAT
        String json = " {\n" +
                "      \"id\": 122,\n" +
                "      \"firstName\": \"Murat\",\n" +
                "      \"lastName\": \"Taskin\",\n" +
                "      \"gradeLevel\": 10,\n" +
                "      \"subject\": \"Advanced Machine Learning\"\n" +
                "    }";
        // Jackson
        ObjectMapper mapper = new ObjectMapper();
        // convert string in INSTRUCTOR
        Professor instructor = mapper.readValue(json, Professor.class);
        System.out.println(instructor.getFirstName());

    }

    @Test
    public void objectToJson() throws JsonProcessingException {
        Professor professor = new Professor();
        professor.setSubject("Intro to CS101");
        professor.setId(34);
        professor.setFirstName("Howard");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(professor);
        System.out.println(json);
    }



    @Test
    public void hitApi() throws IOException {

        Response response = RestAssured.get("http://..........................");
        System.out.println(response.asString());

        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(response.asString(), Student.class);
        System.out.println(student.getFirstName());
        System.out.println(student.getContact().getEmailAddress());

    }
}

