package EventCalendar;

import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {
    Event event;
    private JLabel eventLabel;
    private JButton completeButton;

    EventPanel(Event event) {          //Constructor for the EventPanel
        this.event = event;
        eventLabel = new JLabel("Event: " + event.getName() + " " + event.getDateTime());
        eventLabel.setFont(new Font("Serif", Font.BOLD, 14));

        completeButton = new JButton("Complete");           //Builds the complete button
        //completeButton.addActionListener(e -> {
         //   event.complete();
       // });

        this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(400, 400));

        this.add(eventLabel);
        this.add(completeButton);


    }
}
