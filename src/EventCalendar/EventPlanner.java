package EventCalendar;

import javax.swing.*;
import java.time.LocalDateTime;

public class EventPlanner {
    public static void main(String[] args) {        //Main method for the GUI
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EventListPanel panel = new EventListPanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        addDefaultEvents(panel);

        frame.add(panel);
    }

    static void addDefaultEvents(EventListPanel events) {       //Adds some default events
        Event defaultDeadline = new Deadline("Assignment", LocalDateTime.of(2025, 2, 18, 11, 59));
        Event defaultMeeting = new Meeting("Class", LocalDateTime.of(2025, 2, 18, 4, 0), LocalDateTime.of(2025, 2, 18, 5, 10), "Zoom");

        events.addEvent(defaultDeadline);
        events.addEvent(defaultMeeting);
    }
}
