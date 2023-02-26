package model;

public class Mentor extends User{
    private double experience;
    private double salaryForLesson;

    @Override
    public String toString() {
        return "Mentor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateTimeCreated=" + dateTimeCreated +
                ", experience=" + experience +
                ", salaryForLesson=" + salaryForLesson +
                '}';
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public double getSalaryForLesson() {
        return salaryForLesson;
    }

    public void setSalaryForLesson(double salaryForLesson) {
        this.salaryForLesson = salaryForLesson;
    }
}
