import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String lastName;
    private Gender gender;
    private int age;
    private int salary;
    private int workExperience;
    private Speciality speciality;

    public Employee(int id, String name, String lastName, Gender gender, int age, int salary, int workExperience, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.workExperience = workExperience;
        this.speciality = speciality;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && salary == employee.salary && workExperience == employee.workExperience && Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName) && gender == employee.gender && speciality == employee.speciality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, gender, age, salary, workExperience, speciality);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", salary=" + salary +
                ", workExperience=" + workExperience +
                ", speciality=" + speciality +
                '}';
    }
}
