package EventCalendar;

import java.time.LocalDateTime;

/*Concrete creator for Meeting events, based off the EventFactory class*/
public class MeetingFactory extends EventFactory {
    @Override
    public Event createEvent(String eventName, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        Meeting meeting = new Meeting();
        meeting.setName(eventName);
        meeting.setDateTime(startDateTime);
        meeting.setEndDateTime(endDateTime);
        meeting.setLocation(location);
        return meeting;
    }
}
