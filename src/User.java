

import java.util.ArrayList;
import java.util.List;

//abstract User class. All user types (i.e. students, professors, etc...) inherit from this class
public abstract class User {
    protected String name;
    protected int ID;
    protected String email;
    protected String password;

    protected List<Event> eventList;
    //protected List<Group> groupList;

    //default constructor
    public User() {
        eventList = new ArrayList();
    }

    //returns the name of the user as a string
    public String getName() {
        return name;
    }

    //sets the name of the user to a string
    public void setName(String name) {
        this.name = name;
    }

    //returns the ID of the user as an int
    public int getID() {
        return ID;
    }

    //sets the ID of the user to an int
    public void setID(int ID) {
        this.ID = ID;
    }

    //returns the email of the user as a string
    public String getEmail() {
        return email;
    }

    //sets the email of the user to a string
    public void setEmail(String email) {
        this.email = email;
    }

    //returns the password of a user as a string
    public String getPassword() {
        return password;
    }

    //sets the password of a user to a string
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean addEvent(Event event) {
        eventList.add(event);
        return true;
    }

/*    //public List<Event> getEventList() { return eventList; }

    //public void setEventList(List<Event> eventList) {this.eventList = eventList;}

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }
*/

}
