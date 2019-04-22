

import java.util.List;

public class Event {
    private String eventName;
    private String date;
    private String location;
    private List<String> tag;
    //private CampusConnect.User Creator;

    public static class Builder {
        private String eventName;
        private String date;
        private String location;
        //private CampusConnect.User Creator;

        public Builder(long ID) {
            this.eventName = eventName;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Event build(){
            Event event = new Event();
            event.eventName = this.eventName;
            event.date = this.date;
            event.location = this.location;

            return event;
        }
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
}