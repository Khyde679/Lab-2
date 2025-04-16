package EventCalendar;

import java.time.LocalDateTime;

/**Factory Class and Method for creating new Event Types based on user input**/
public class EventFactory {
    public static Event getEvent(String type, String eventName, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        if ("Deadline".equals(type)) {
            return new Deadline(eventName, startDateTime);
        } else if ("Meeting".equals(type)) {
            return new Meeting(eventName, startDateTime, endDateTime, location);
        }

        return null;
    }
}
