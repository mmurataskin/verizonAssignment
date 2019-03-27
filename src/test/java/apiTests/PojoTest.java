package apiTests;

import modelsApi.Professor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class PojoTest {

    @Test
    public void testPojo() throws Exception {
        Professor in = new Professor();
        in.setGradeLevel(10);
        in.setFirstName("James");
        in.setLastName("Milner");
        in.setId(7);
        in.setSubject("Intro to Soccer");
        // jackson converting object into json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(in);
        System.out.println(json);

        //convert json on Object

        Professor professor2 = mapper.readValue(json, Professor.class);
        System.out.println(professor2.getFirstName());
    }
}