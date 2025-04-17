package EventCalendar;

import java.time.LocalDateTime;

/*Factory Class containing abstract Factory method and method call to be overridden*/
abstract public class EventFactory {
    abstract public Event createEvent(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String location);

    public Event getEvent(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        Event event = createEvent(name, startDateTime, endDateTime, location);
        return event;
    }
}
