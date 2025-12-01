package Collections.Task_1;

import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private String course;

    // Static list
    private static ArrayList<Student> studentList = new ArrayList<>();

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // ADD
    public static void addStudent(Student s) {
        studentList.add(s);
        System.out.println("Student added: " + s.name);
    }

    // SHOW ALL
    public static void showStudents() {
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    // SEARCH
    public static Student searchStudent(int id) {
        for (Student s : studentList) {
            if (s.id == id) return s;
        }
        return null;
    }

    // UPDATE
    public static void updateStudent(int id, String newName, String newCourse) {
        Student s = searchStudent(id);

        if (s != null) {
            s.name = newName;
            s.course = newCourse;
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found!");
        }
    }

    // DELETE
    public static void deleteStudent(int id) {
        Student s = searchStudent(id);
        if (s != null) {
            studentList.remove(s);
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found!");
        }
    }

    @Override
    public String toString() {
        return "Student { id=" + id + ", name='" + name + "', course='" + course + "' }";
    }

    public static void main(String[] args) {

        addStudent(new Student(1, "Jack", "Java"));
        addStudent(new Student(2, "Emma", "Python"));

        System.out.println("\nAll Students:");
        showStudents();

        System.out.println("\nSearching ID = 1");
        System.out.println(searchStudent(1));

        System.out.println("\nUpdating ID = 2");
        updateStudent(2, "Emma Watson", "Spring Boot");

        System.out.println("\nAll Students After Update:");
        showStudents();

        System.out.println("\nDeleting ID = 1");
        deleteStudent(1);

        System.out.println("\nAll Students After Delete:");
        showStudents();
    }
}
