package lab2.models;

public class Student {
    private final String id;
    private final String name;
    private final String parentPhone;
    private final String parentEmail;

    public Student(String id, String name, String parentPhone, String parentEmail) {
        this.id = id;
        this.name = name;
        this.parentPhone = parentPhone;
        this.parentEmail = parentEmail;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getParentPhone() { return parentPhone; }
    public String getParentEmail() { return parentEmail; }

    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}
