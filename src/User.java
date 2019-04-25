
import java.util.ArrayList;
import java.util.List;


public abstract class User {
    protected String name;
    protected int ID;
    protected String email;
    protected String password;

    //protected List<Event> eventList;
    //protected List<Group> groupList;

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
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
