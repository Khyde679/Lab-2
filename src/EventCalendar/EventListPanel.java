package EventCalendar;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.function.Predicate;

public class EventListPanel extends JPanel {
    EventContext eventContext;
    ArrayList<Event> events;
    DisplayStrategy displayStrategy;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox<String> sortDropDown;
    JComboBox<String> displayStyle;
    ArrayList<JCheckBox> filterDisplay;
    Map<String, Predicate<Event>> filters;
    JButton addEventButton;
    final String[] SORT_OPTIONS = {"NAME", "DATE", "REVERSE NAME", "REVERSE DATE"};
    final String[] DISPLAY_OPTIONS = {"LIST"};

    EventListPanel() {          //Constructor for the EventListPanel
        setPreferredSize(new Dimension(1000, 750));
        setBackground(Color.DARK_GRAY);
        events = new ArrayList<>();

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.LIGHT_GRAY);
        controlPanel.setPreferredSize(new Dimension(750, 57));

        addEventButton = new JButton("Add Event");          //Creates the add event button and redirects to the modal to build a new event
        addEventButton.addActionListener(e -> {
            new AddEventModal(this);
        });

        controlPanel.add(addEventButton);

        sortDropDown = new JComboBox<>(SORT_OPTIONS);               //Builds the drop-down menu to sort the events
        sortDropDown.setFont(new Font("Arial", Font.BOLD, 30));
        sortDropDown.addActionListener(e -> {
            if (Objects.equals(sortDropDown.getSelectedItem(), SORT_OPTIONS[0])) {
                Collections.sort(events);
            }
            if (Objects.equals(sortDropDown.getSelectedItem(), SORT_OPTIONS[1])) {
                Collections.sort(events);
            }
            if (Objects.equals(sortDropDown.getSelectedItem(), SORT_OPTIONS[2])) {
                events.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()) * -1);
            }

            updateDisplay();
        });
        controlPanel.add(sortDropDown);

        eventContext = new EventContext();
        displayStyle = new JComboBox<>(DISPLAY_OPTIONS);
        displayStyle.setFont(new Font("Arial", Font.BOLD, 30));
        displayStyle.addActionListener(e -> {
            if (Objects.equals(displayStyle.getSelectedItem(), DISPLAY_OPTIONS[0])) {
                displayStrategy = new ListDisplay();
                displayPanel = eventContext.selectDisplay(displayStrategy, events);
            }
        });
        displayStyle.setSelectedIndex(0);
        controlPanel.add(displayStyle);


        filters = new HashMap<>();          //Builds and adds check boxes to filter meetings by
        filterDisplay = new ArrayList<>();
        for (String sortOption : SORT_OPTIONS) {
            filterDisplay.add(new JCheckBox(sortOption));
        }
        for (String filter : filters.keySet()) {
            JCheckBox box = new JCheckBox(filter);
            box.setFont(new Font("Arial", Font.BOLD, 30));
            box.addItemListener(e -> updateDisplay());
            filterDisplay.add(box);
        }

        add(controlPanel);

        add(displayPanel);
        updateDisplay();
    }

    public void addEvent(Event event) {     //Method to add new events
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
                displayPanel.add(new EventContext().selectDisplay(displayStrategy, events));
            }
        }

        revalidate();
        repaint();
    }
}
