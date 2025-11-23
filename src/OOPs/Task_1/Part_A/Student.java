package OOPs.Task_1.Part_A;

public class Student {

    // Encapsulation Attributes
    private int id;
    private String name;
    private int age;
    private String course;
    private double grade;

    // Parameterized Constructor
    Student(int id, String name, int age, String course, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.grade = grade;
    }

    // Methods
    public void study() {
        System.out.println(name + " is Studying " + course);
    }

    public void updateGrade(double grade) {
        this.grade = grade;
        System.out.println("Grade Updated to " + grade);
    }

    public void displayInfo() {
        System.out.println(this.toString());
    }

    // Getter & Setter
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }
    public String getCourse() { return course; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }
    public void setGrade(double grade) { this.grade = grade; }

    // toString()
    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", course='" + getCourse() + '\'' +
                ", grade=" + getGrade() +
                '}';
    }

    // Method to Update Student
    public void updateStudent(int id, String name, int age, String course, double grade) {
        setId(id);
        setName(name);
        setAge(age);
        setCourse(course);
        setGrade(grade);
        displayInfo();
    }

    public static void main(String[] args){

        Student student1 = new  Student(1,"Jack",20,"Computer Science",7.8);

        student1.displayInfo();

        student1.updateGrade(8.0);

        student1.study();

        student1.updateStudent(5,"Jack Wayne",21,"Computer Science & AI",8.2);

    }
}
