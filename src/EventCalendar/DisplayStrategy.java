package EventCalendar;

import java.awt.*;
import java.util.ArrayList;

public interface DisplayStrategy {
    Component displayEvents(ArrayList<Event> events);
}
