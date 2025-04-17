package EventCalendar;

/**Factory Class and Method for creating new Event Types based on user input**/
abstract public class EventFactory {
    abstract public Event createEvent();

    public void getEvent() {
        Event event = createEvent();

    }
}
