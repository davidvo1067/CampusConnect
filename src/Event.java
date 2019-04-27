

import java.util.ArrayList;
import java.util.List;
/*This public class creates and stores events. It contains a builder that builds the actual event with a set of
methods that allow for the addition of specific information.
 */
public class Event {
    private String eventName;
    private String date;
    private String location;
    private List<String> tag;
    private List<User> listOfAttedee;
    private int ID;
    //private CampusConnect.User Creator;

    //default constructor.
    private Event () {
        tag = new ArrayList();
        listOfAttedee = new ArrayList();
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
        listOfAttedee.add(attendee);
        return true;
    }

    //returns the name of the event as a string
    public String getEventName() {
        return eventName;
    }

    //sets the name of the event to a string
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    //returns the date as a string
    public String getDate() {
        return date;
    }

    //sets the date to a string
    public void setDate(String date) {
        this.date = date;
    }

    //returns the location of an event as a string
    public String getLocation() {
        return location;
    }

    //sets the location of an event to a string
    public void setLocation(String location) {
        this.location = location;
    }

    //returns the ID of an event as an int
    public int getID() {
        return ID;
    }

    //sets the ID of an event to an int
    public void setID(int ID) {
        this.ID = ID;
    }


    @Override
    public String toString() {
        String listOfPeople="";
        for (User person: listOfAttedee ) {
            listOfPeople += " "+ person.getName() + ", ";
        }
        return  "ID " +
                eventName +"at " + location + ' ' + date + "\n" +
                ", list of People: listOfPeople" + listOfPeople;

    }
}