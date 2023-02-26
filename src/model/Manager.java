package model;

public class Manager extends User {
    private double salary;

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateTimeCreated=" + dateTimeCreated +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
