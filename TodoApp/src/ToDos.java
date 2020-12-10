import java.io.Serializable;
import java.time.LocalDateTime;

public class ToDos implements Serializable {
    private boolean status;
    private String priority;
    private final String description;
    private final String timeAdded;

    private LocalDateTime dateTime;

    public ToDos (String description){
        dateTime = LocalDateTime.now();
        status = false;
        timeAdded = dateTime.toString();
        this.description = description;
        this.priority = "normal";
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public String getTimeAdded() {
        return timeAdded;
    }

    @Override
    public String toString() {
        return (status ? "[x] " : "[ ] ") + description + "%  " + timeAdded + "%  " + priority;
    }
}
