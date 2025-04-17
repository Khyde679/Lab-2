package EventCalendar;

import java.time.LocalDateTime;

public class Deadline implements Completable, Event {
    private String name;
    private LocalDateTime dateTime;
    private boolean complete;       //Boolean to track if the associated task is complete


    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    @Override
    public String getType() {
        return "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public void complete() {
        complete = true;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    @Override
    public int compareTo(Event e) {
        return dateTime.compareTo(e.getDateTime());
    }
}
