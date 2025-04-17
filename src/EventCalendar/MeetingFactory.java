package EventCalendar;

import java.time.LocalDateTime;

public class MeetingFactory extends EventFactory {
    @Override
    public Event createEvent(String eventName, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        return new Meeting();
    }
}
