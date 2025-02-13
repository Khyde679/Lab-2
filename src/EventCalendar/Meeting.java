package EventCalendar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Meeting extends Event implements Completable{
    private String location;            //Private string to track the location of the meeting
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;  //Private variable to track when the meeting is going to end
    private boolean complete;

    public Meeting(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        super(name, startDateTime);
        this.startDateTime = startDateTime;
        this.location = location;
        this.endDateTime = endDateTime;
    }


    LocalDateTime getEndDateTime() {        //Getter for the end of the meeting
        return endDateTime;
    }

    Duration getDuration() {                                 //Getter for the duration of the meeting, calculated by subtracting the
        return Duration.between(startDateTime, endDateTime);
    }

    String getLocation() {      //Getter for the location of the meeting
        return location;
    }

    void setEndDateTime(LocalDateTime end) {     //Setter for the end time of the meeting
        endDateTime = end;
    }

    void setLocation(String location) {     //Setter for the location of the meeting
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
}
