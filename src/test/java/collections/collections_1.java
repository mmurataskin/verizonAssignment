
package collections;

import org.junit.Test;

import java.util.*;

public class collections_1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("James");
        names.add("John");
        names.add("Emily");
        names.add("Josh");

        System.out.println(names);
        System.out.println();

        // queue example(FIFO)

        Queue<String> candidates = new PriorityQueue<>();
        candidates.add("Person1");
        candidates.add("Person2");
        candidates.add("Person3");
        candidates.add("Person4");
        System.out.println(candidates);
        System.out.println();

        // peek --> value of 1st value
        System.out.println(candidates.peek());
        System.out.println("Size of candidates: " );
        System.out.println(candidates.size());


        List<String> students = new LinkedList<>();
        students.add("Student1");
        students.add("Student2");
        students.add("Student3");
        students.add("Student4");
        System.out.println(students);
        students.add(1, "Student Unknown");
        System.out.println(students);
        System.out.println(((LinkedList<String>) students).getFirst());
    }
    @Test
    public void mapping(){
        Map<String, String> config = new HashMap<>();
        config.put("url", "jbond");
        System.out.println(config);

        Set<String> keys = config.keySet();
        System.out.println(config.get("password"));


        for(String each: keys){
            System.out.println(each);

        }



    }
}
