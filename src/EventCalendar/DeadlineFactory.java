package EventCalendar;

import java.time.LocalDateTime;

public class DeadlineFactory extends EventFactory {
    @Override
    public Event createEvent(String eventName, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        return new Deadline();
    }
}
