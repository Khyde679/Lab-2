package EventCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class EventListPanel extends JPanel {
    ArrayList<Event> events;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox<String> sortDropDown;
    ArrayList<JCheckBox> filterDisplay;
    Map<String, Predicate<Event>> filters;
    JButton addEventButton;
    final String[] SORT_OPTIONS = {"NAME", "DATE", "REVERSE NAME", "REVERSE DATE"};

    EventListPanel() {          //Constructor for the EventListPanel
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.GREEN);
        events = new ArrayList<>();

        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(400, 50));

        addEventButton = new JButton("Add Event");          //Creates the add event button and redirects to the modal to build a new event
        addEventButton.addActionListener(e -> {
            new AddEventModal(this);
        });

        controlPanel.add(addEventButton);

        sortDropDown = new JComboBox<>(SORT_OPTIONS);               //Builds the drop-down menu to sort the events
        sortDropDown.setFont(new Font("Arial", Font.BOLD, 30));
        sortDropDown.addActionListener(e -> {
            if (sortDropDown.getSelectedItem().equals(SORT_OPTIONS[0])) {
                Collections.sort(events);
            }
            if (sortDropDown.getSelectedItem().equals(SORT_OPTIONS[1])) {
                Collections.sort(events);
            }
            if (sortDropDown.getSelectedItem().equals(SORT_OPTIONS[2])) {
                events.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()) * -1);
            }

            updateDisplay();
        });
        controlPanel.add(sortDropDown);

        filters = new HashMap<>();          //Builds and adds check boxes to filter meetings by
        filterDisplay = new ArrayList<>();
        for (String filter : filters.keySet()) {
            JCheckBox box = new JCheckBox(filter);
            box.setFont(new Font("Arial", Font.BOLD, 30));
            box.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    updateDisplay();
                }
            });
            filterDisplay.add(box);
        }

        add(controlPanel);

        displayPanel = new JPanel();        //Displays the events
        displayPanel.setPreferredSize(new Dimension(400, 200));
        add(displayPanel);
    }

    public void addEvent(Event event) {     //Method to add new events
        EventPlanner.addDefaultEvents(this);

        events.add(event);
        updateDisplay();
    }

    public boolean isFiltered(Event event) {        //Checks event against filters, returns if they are or are not part of said filter
        boolean filtered = false;

        for (JCheckBox filter : filterDisplay) {
            if (filter.isSelected()) {
                Predicate<Event> pred = filters.get(filter.getText());
                if (pred.test(event)) {
                    filtered = true;
                }
            }
        }

        return filtered;
    }

    public void updateDisplay() {           //Adds all non-filtered events to the display panel
        displayPanel.removeAll();
        for (Event event : events) {
            if (!isFiltered(event)) {
                displayPanel.add(new EventPanel(event));
            }
        }

        revalidate();
        repaint();
    }
}
