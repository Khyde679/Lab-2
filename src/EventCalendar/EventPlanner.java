package EventCalendar;

import javax.swing.*;

public class EventPlanner {
    public static void main(String[] args) {        //Main method for the GUI
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EventListPanel panel = new EventListPanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    static void addDefaultEvents(EventListPanel events) {

    }
}
