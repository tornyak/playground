package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Collections.addAll(students,
                new Student("Bugzy", 185),
                new Student("Lucifer", 198),
                new Student("Monster", 200)
        );

        students.sort(null);
        students.forEach(System.out::println);
    }
}
