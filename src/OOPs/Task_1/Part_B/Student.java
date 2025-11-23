package OOPs.Task_1.Part_B;

public class Student extends Person {

    Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public void work() {
        System.out.println("Student is studying");
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Tom Sparrow", 19);
        student1.printDetails();
        student1.work();
    }
}
