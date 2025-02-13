package EventCalendar;

import java.time.LocalDateTime;

abstract class Event implements Comparable<Event> {
    private String name;                //Private variable for the name of the event
    private LocalDateTime dateTime;     //Private variable for the date and time of the event

    public Event(String name, LocalDateTime dateTime) {     //Constructor for the event
        this.name = name;
        this.dateTime = dateTime;
    }

    String getName() {      //Getter for the event, returns its name
        return name;
    }

    LocalDateTime getDateTime() {   //Getter for the date and time, returns the date and time
        return dateTime;
    }

    void setName(String name) {     //Setter for the event, sets its name
        this.name = name;
    }

    void setDateTime(LocalDateTime dateTime) {  //Setter for the event, sets the date and time for the event
        this.dateTime = dateTime;
    }

    @Override
    public int compareTo(Event e) {                    //Compares the date of the current event to an incoming one, returns a
        return dateTime.compareTo(e.dateTime);  //positive int if its later, negative if sooner, 0 if simultaneous
    }
}
