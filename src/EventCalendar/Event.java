package EventCalendar;

import java.time.LocalDateTime;

interface Event extends Comparable<Event> {
    String getName();
    LocalDateTime getDateTime();
    String getType();
    void setName(String name);
    void setDateTime(LocalDateTime dateTime);
    @Override
    int compareTo(Event e);
}
