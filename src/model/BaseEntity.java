package model;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    protected long id;
    protected LocalDateTime dateTimeCreated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", dateTimeCreated=" + dateTimeCreated +
                '}';
    }
}
