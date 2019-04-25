

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventName;
    private String date;
    private String location;
    private List<String> tag;
    private List<User> listOfAttedee;
    private int ID;
    //private CampusConnect.User Creator;

    private Event () {
        tag = new ArrayList();
        tag.add("Study");
    }
    public static class Builder {
        private String eventName;
        private String date;
        private String location;
        private int ID;

        //private CampusConnect.User Creator;

        public Builder(int ID) {
            this.ID = ID;
        }

        public Builder withName(String name) {
            this.eventName = name;
            return this;
        }
        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withID(int ID) {
            this.ID = ID;
            return this;
        }

        public Event build(){
            Event event = new Event();
            event.eventName = this.eventName;
            event.date = this.date;
            event.location = this.location;
            event.ID = this.ID;
            return event;
        }
    }

    public boolean addAttendee(User attendee) {
        listOfAttedee.add (attendee);
        return true;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        String listOfPeople="";
        for (User person: listOfAttedee ) {
            listOfPeople += " "+ person.getName() + " ";
        }
        return "Event{" +
                ", ID=" + ID +
                "eventName='" + eventName + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", tag=" + tag +
                ", list of People: listOfPeople" +
                '}';

    }
}