package OOPs.Task_1.Part_B;

public class Person implements PrintDetails {

    // Attributes (Encapsulation)
    private int id;
    private String name;
    private int age;

    // Constructor
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // Method which overrides by child class
    public void work() {
        System.out.println("Person is working");
    }


    // Method implementation for abstract methods
    @Override
    public void printDetails() {
        System.out.println(String.format("%s, %s, %s", id, name, age));
    }
}
