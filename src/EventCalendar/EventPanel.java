package EventCalendar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class EventPanel extends JPanel implements DisplayStrategy {
    EventPanel(ArrayList<Event> events) {
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(400, 350));
        displayEvents(events);
    }

    @Override
    public void displayEvents(ArrayList<Event> events) {

    }
}
