package EventCalendar;

import java.time.LocalDateTime;

/**Factory Class and Method for creating new Event Types based on user input**/
abstract public class EventFactory {
    abstract public Event createEvent(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String location);

    public void getEvent(String eventName, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        Event event = createEvent(eventName, startDateTime, endDateTime, location);
    }
}
