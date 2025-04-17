package EventCalendar;

public class MeetingFactory extends EventFactory {
    @Override
    public Event createEvent() {
        return new Meeting();
    }
}
