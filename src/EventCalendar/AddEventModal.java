package EventCalendar;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddEventModal extends JDialog {
    private EventListPanel eventListPanel;
    AddEventModal modal;
    record Attribute(String name, JComponent value) {};
    ArrayList<Attribute> attributes;
    JPanel inputPanel;
    JComboBox<String> eventTypeComboBox;
    public static final String[] eventTypes = {"Deadline", "Meeting"};

    public AddEventModal(EventListPanel eventListPanel) { //builds the modal to create a JFrame and add the following to it
        modal = this;
        this.eventListPanel = eventListPanel;

        this.setTitle("Add Event");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().add(addEventPanel());
        this.pack();
        this.setVisible(true);
    }

    private JPanel addEventPanel() {        //Panel where you input the information for a new event to be added to the display
        JPanel panel = new JPanel();
        attributes = new ArrayList<>();

        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(600, 400));
        inputPanel.setBackground(Color.LIGHT_GRAY);

        eventTypeComboBox = new JComboBox<>(eventTypes);            //Stores the possible types of events
        eventTypeComboBox.addActionListener(getEventChooser());     //Allows you to choose between the types of events to create

        panel.add(eventTypeComboBox);
        panel.add(inputPanel);

        JButton addEventButton = new JButton("Submit");     //Finalizes the creation of the event
        addEventButton.addActionListener(getEventCreator());    //Creates the panel where you create the actual event

        panel.setPreferredSize(new Dimension(500, 500));
        panel.add(addEventButton);

        return panel;
    }

    private ActionListener getEventChooser() {      //Method to create the types of events you can create, deadlines or meetings
        return e -> {
            attributes.clear();
            inputPanel.removeAll();
            switch (eventTypeComboBox.getSelectedIndex()) {     //Case for Deadlines
                case 0: {
                    attributes.add(new Attribute ("Name", new JTextField(10)));
                    attributes.add(new Attribute ("Date and Time (YYYY-MM-DDTHH:MM)", new JTextField(10)));
                    break;
                }
                case 1: {       //Case for meetings
                    attributes.add(new Attribute ("Name", new JTextField(10)));
                    attributes.add(new Attribute ("Start Date and Time (YYYY-MM-DDTHH:MM)", new JTextField(10)));
                    attributes.add(new Attribute ("End Date and Time (YYYY-MM-DDTHH:MM)", new JTextField(10)));
                    attributes.add(new Attribute ("Location", new JTextField(10)));
                    break;
                }
            }

            attributes.forEach(attr -> {
                JLabel label = new JLabel(attr.name);
                inputPanel.add(label);
                inputPanel.add(attr.value);
            });
            inputPanel.revalidate();
            inputPanel.repaint();
         };
    }

    private ActionListener getEventCreator() {      //Method to input the values for the events, such as name, time, location, etc
        return e -> {
            Event newEvent = null;
            switch (eventTypeComboBox.getSelectedIndex()) {
                case 0: {       //Case for Deadlines
                    DeadlineFactory newFactory = new DeadlineFactory();
                    newEvent = newFactory.createEvent(getInput(attributes.get(0).value), LocalDateTime.parse(getInput(attributes.get(1).value)), null, null);
                    //newEvent = new Deadline(getInput(attributes.get(0).value), LocalDateTime.parse((CharSequence) attributes.get(1).value));
                    break;
                }
                case 1: {       //Case for Meetings
                    MeetingFactory newFactory = new MeetingFactory();
                    newEvent = newFactory.createEvent(getInput(attributes.get(0).value), LocalDateTime.parse(getInput(attributes.get(1).value)),
                            LocalDateTime.parse(getInput(attributes.get(2).value)), getInput(attributes.get(3).value));
                    //newEvent = new Meeting(getInput(attributes.get(0).value), LocalDateTime.parse((CharSequence) attributes.get(1).value),
                            //LocalDateTime.parse((CharSequence) attributes.get(2).value), getInput(attributes.get(3).value));
                    break;
                }
            }
            eventListPanel.addEvent(newEvent);
            modal.dispose();
        };
    }

    private String getInput (JComponent c) {        //Get text from JComponent
        if (c instanceof JTextComponent) {
            return ((JTextComponent) c).getText();
        }
        return "";
    }
}
