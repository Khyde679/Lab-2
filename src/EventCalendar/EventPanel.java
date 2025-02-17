package EventCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class EventPanel extends JPanel {
    private Event event;
    private JLabel eventLabel;
    private JButton completeButton;

    EventPanel() {
        eventLabel = new JLabel();
        this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(400, 400));



        System.out.println(event.getName());
        System.out.println(event.getDateTime());

        this.add(eventLabel);


    }
}
