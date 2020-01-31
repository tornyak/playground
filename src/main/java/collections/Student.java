package collections;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private final String name;
    private final int iq;

    public Student(String name, int iq) {
        this.name = name;
        this.iq = iq;
    }

    public final static Comparator<Student> NATURAL = Comparator.
            comparingInt(Student::getIq).reversed().
            thenComparing(Student::getName);

    public String getName() {
        return name;
    }

    private int getIq() {
        return iq;
    }

    @Override
    public int compareTo(Student that) {
        return NATURAL.compare(this, that);
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', iq=%d}", name, iq);
    }
}
