package EventCalendar;

import java.time.LocalDateTime;

public class Deadline extends Event implements Completable{
    private boolean complete;       //Boolean to track if the associated task is complete

    public Deadline(String name, LocalDateTime dateTime) {      //Constructor for the deadline
        super(name, dateTime);
    }


    @Override
    public void complete() {        //Method to set the associated task to complete if it is completed
        complete = true;
    }

    @Override
    public boolean isCompleted() {  //Method to check if this specific event is complete or not
        return complete;
    }
}
