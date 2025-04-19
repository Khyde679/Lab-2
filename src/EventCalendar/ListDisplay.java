package EventCalendar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class ListDisplay extends JPanel implements DisplayStrategy {
    Event event;
    JLabel eventLabel;
    JButton completeButton;

    @Override
    public JPanel displayEvents(ArrayList<Event> events) {
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
        revalidate();
        repaint();
        return this;
    }
}
