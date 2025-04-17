package EventCalendar;

import java.time.LocalDateTime;

/*Concrete creator for Deadline events based on EventFactory*/
public class DeadlineFactory extends EventFactory {
    @Override
    public Event createEvent(String eventName, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        Deadline deadline = new Deadline();
        deadline.setName(eventName);
        deadline.setDateTime(startDateTime);
        return deadline;
    }
}
