package EventCalendar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
    ArrayList<Event> events;
    EventPanel eventPanel;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox sortDropDown;
    JCheckBox filterDisplay;
    JButton addEventButton;

    EventListPanel() {
        events = new ArrayList<>();
        displayPanel = new JPanel();
        controlPanel = new JPanel();
        sortDropDown = new JComboBox();
        filterDisplay = new JCheckBox();
        addEventButton = new JButton();
        eventPanel = new EventPanel();

        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(500, 500));
        controlPanel.setBackground(Color.BLUE);
        displayPanel.setBackground(Color.YELLOW);
        controlPanel.setPreferredSize(new Dimension(400, 75));
        displayPanel.setPreferredSize(new Dimension(400, 75));
        this.add(controlPanel);
        this.add(displayPanel);
        this.add(eventPanel);


    }
}
