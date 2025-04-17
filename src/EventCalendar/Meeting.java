package EventCalendar;

import java.time.Duration;
import java.time.LocalDateTime;

public class Meeting implements Completable, Event {
    private String name;
    private String location;            //Private string to track the location of the meeting
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;  //Private variable to track when the meeting is going to end
    private boolean complete;

    public LocalDateTime getEndDateTime() {        //Getter for the end of the meeting
        return endDateTime;
    }

    public Duration getDuration() {                                 //Getter for the duration of the meeting, calculated by subtracting the
        return Duration.between(startDateTime, endDateTime);
    }

    @Override
    public String getType() {
        return "Meeting";
    }

    public String getLocation() {      //Getter for the location of the meeting
        return location;
    }

    public void setEndDateTime(LocalDateTime end) {     //Setter for the end time of the meeting
        endDateTime = end;
    }

    public void setLocation(String location) {     //Setter for the location of the meeting
        this.location = location;
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
    public String getName() {
        return name;
    }

    @Override
    public LocalDateTime getDateTime() {
        return startDateTime;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDateTime(LocalDateTime dateTime) {
        this.startDateTime = dateTime;
    }

    @Override
    public int compareTo(Event e) {
        return startDateTime.compareTo(e.getDateTime());
    }
}
