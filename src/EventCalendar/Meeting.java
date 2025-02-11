package EventCalendar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class Meeting extends Event implements Completable{
    private String location;            //Private string to track the location of the meeting
    private LocalDateTime endDateTime;  //Private variable to track when the meeting is going to end
    private boolean complete;


    public Meeting(String name, LocalDateTime dateTime) {   //Constructor for the meeting
        super(name, dateTime);
    }

    LocalDateTime getEndDateTime() {        //Getter for the end of the meeting
        return endDateTime;
    }

    Duration getDuration() {                            //Getter for the duration of the meeting, calculated by subtracting the
        return (Duration) (dateTime - endDateTime);     //current time (start time) from the end time of the meeting
    }

    String getLocation() {      //Getter for the location of the meeting
        return location;
    }

    void setEndTime(Date end) {     //Setter for the end time of the meeting
        this.endDateTime = end;
    }

    void setLocation(String location) {     //Setter for the location of the meeting
        this.location = location;
    }

    @Override
    public void complete() {
        complete = true;
    }

    @Override
    public boolean isCompleted() {
        return complete;
    }
}
