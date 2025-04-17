package EventCalendar;

public class DeadlineFactory extends EventFactory {
    @Override
    public Event createEvent() {
        return new Deadline();
    }
}
