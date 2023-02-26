package model;

public class Group extends BaseEntity{
    private String name;
    private String room;
    private String startTime;

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", startTime='" + startTime + '\'' +
                ", dateTimeCreated=" + dateTimeCreated +
                '}';
    }
}
