package EventCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventPanel extends JPanel {
    private Event event;
    private JButton completeButton;

    EventPanel() {
        completeButton = new JButton("Complete");

        this.setBackground(Color.GRAY);
        completeButton.setBackground(Color.LIGHT_GRAY);
        completeButton.addActionListener(new InputListener());

    }
}
