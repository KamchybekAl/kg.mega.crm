package model;

public class Manager extends User {
    private double salary;

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateTimeCreated=" + dateTimeCreated +
                ", salary=" + salary +
                '}';
    }
}
