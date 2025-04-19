package EventCalendar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class EventContext extends JPanel {
    DisplayStrategy displayStrategy;


    EventContext() {
        displayStrategy = new ListDisplay();
    }

    public JPanel selectDisplay(DisplayStrategy ds, ArrayList<Event> events) {
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(650, 500));
        displayStrategy = ds;
        add(displayStrategy.displayEvents(events));
        return this;
    }
}
