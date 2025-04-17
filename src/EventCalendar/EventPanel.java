package EventCalendar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class EventPanel extends JPanel {
    Event event;
    private JLabel eventLabel;
    private JButton completeButton;

    EventPanel(ArrayList<Event> events) {
        for (Event e : events) {
            if (Objects.equals(e.getType(), "Deadline")) {
                eventLabel = new JLabel("Deadline" + e.getName() + " " + e.getDateTime());
            } else if (Objects.equals(e.getType(), "Meeting")) {
                eventLabel = new JLabel("Meeting" + e.getName() + " " + e.getDateTime());
            }
            eventLabel.setFont(new Font("Serif", Font.BOLD, 14));
            add(eventLabel);


            completeButton = new JButton("Complete");
            completeButton.addActionListener(c -> {
                if (event != null) {
                    event.complete();
                }
            });
            add(completeButton);
        }

        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(400, 350));
    }

    EventPanel(Event event, ArrayList<Event> events) {          //Constructor for the EventPanel
        this.event = event;
        for (Event e : events) {
            if (Objects.equals(e.getType(), "Deadline")) {
                eventLabel = new JLabel("Deadline: " + e.getName() + " " + e.getDateTime());
            } else if (Objects.equals(e.getType(), "Meeting")) {
                eventLabel = new JLabel("Meeting: " + e.getName() + " " + e.getDateTime());
            }
            eventLabel.setFont(new Font("Serif", Font.BOLD, 14));
            add(eventLabel);

            completeButton = new JButton("Complete");
            completeButton.addActionListener(c -> {
                if (event != null) {
                    event.complete();
                }
            });
            add(completeButton);
        }

        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(400, 350));
    }
}
