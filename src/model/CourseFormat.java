package model;

public class CourseFormat extends BaseEntity {

    private String format;
    private int durationInWeek;
    private boolean isOnline;
    private int lessonDuration;
    private int lessonCountPerWeek;



    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getDurationInWeek() {
        return durationInWeek;
    }

    public void setDurationInWeek(int durationInWeek) {
        this.durationInWeek = durationInWeek;
    }

    public boolean getisOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getLessonDuration() {
        return lessonDuration;
    }

    public void setLessonDuration(int lessonDuration) {
        this.lessonDuration = lessonDuration;
    }

    public int getLessonCountPerWeek() {
        return lessonCountPerWeek;
    }

    public void setLessonCountPerWeek(int lessonCountPerWeek) {
        this.lessonCountPerWeek = lessonCountPerWeek;
    }

    @Override
    public String toString() {
        return "CourseFormat{" +
                "id=" + id +
                ", format='" + format + '\'' +
                ", durationInWeek=" + durationInWeek +
                ", isOnline=" + isOnline +
                ", lessonDuration=" + lessonDuration +
                ", lessonCountPerWeek=" + lessonCountPerWeek +
                ", dateTimeCreated=" + dateTimeCreated +
                '}';
    }
}
