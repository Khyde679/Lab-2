package EventCalendar;

import java.time.Duration;
import java.time.LocalDateTime;

interface Event extends Comparable<Event>, Completable {
    String getName();
    LocalDateTime getDateTime();
    LocalDateTime getEndDateTime();
    String getLocation();
    Duration getDuration();
    String getType();
    void setName(String name);
    void setDateTime(LocalDateTime dateTime);
    void setEndDateTime(LocalDateTime endDateTime);
    void setLocation(String location);
    @Override
    int compareTo(Event e);
}
