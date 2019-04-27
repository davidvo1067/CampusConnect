import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.println;

/*School class is used here as a general catch-all for all of the entities that exist within a school.
This includes the creation and logging-in of users, finding users, creating events, finding events, and displaying
events.
 */
public class School {
    //userCounter keeps track of the user's ID, which is determined based on the order that the users are created
    public int userCounter = 0;
    //eventCoutner keeps track of the event's ID, which is determined based on the order that the events are created
    public int eventCounter = 0;
    //UserList stores the
    private List<User> UserList;
    private List<Event> EventList;

    //default constructor. initializes new lists for users
    public School() {
        //initiallizes a new empty userlist
        UserList = new ArrayList();
        //initializes a new empty eventlist
        EventList = new ArrayList();
        createUser("Student","John", "john@john.com", "nopassword");
        createUser("Student","Kelly Johnson", "whatAmIeatingToday@today.com", "kelly" );
        createUser("Student","Harry", "harry@harryIsCool.com", "harry");
        createUser("Student","Yamato", "yamato@yamoto.com", "yamoto");
        createEvent("343 Study Group Study", "5/2/2019","Lib2-305");
        createEvent("490 Study Group Study", "5/3/2019","Lib-315");
    }

    //creates a new user based on their usertype. Includes their name, email, and password
    public int createUser(String userType, String name, String email, String password) {
        System.out.println("Register status: ");
        int userID = findUser(email);
        if (userID == 0) {
            if (userType.toLowerCase().equals("student")) {
                UserList.add(
                        new Student.Builder(++userCounter)
                                .withName(name)
                                .withEmail(email)
                                .withPassword(password)
                                .build()
                );

                System.out.println("Created " + email + "  Student complete \n");
                return userID ;
            }

            if(userType.toLowerCase().equals("professor"))
            {
                UserList.add(
                        new Professor.Builder(++userCounter)
                                .withName(name)
                                .withEmail(email)
                                .withPassword(password)
                                .build()
                );
            }
        } else {
            System.out.println("User already exists \n");
            return 0;
        }
        return 0;
    }

    //logs in a user. Checks to see if their email and password combination is valid
    public int login(String email, String password) {
        System.out.println("Start login process");
        int userID = findUser(email);
        if (userID != 0L) {
            if (UserList.get(userID - 1).getPassword().equals(password)) {
                System.out.println("Log in success:");
                System.out.println("--------" + email + "'s profile----");
                System.out.println(UserList.get(userID - 1).toString());
                System.out.println("--------------------- \n");
                return userID;
            } else {
                System.out.println("Log in failure: wrong password+ \n");
                return 0;
            }
        } else {
            System.out.println("Log in failure: the email is not exist in the system + \n");
            return 0;
        }
    }
    //checks to see if a user already exists in the UserList
    private int findUser(String email) {

        for (User existUser : UserList) {
            if (existUser.getEmail().equals(email)) {
                return existUser.getID();
            }
        }
        return 0;
    }

    //creates a new event using the event builder.
    public int createEvent(String name, String date, String location) {
        int eventID = findEvent(name);
        if (eventID== 0) {
            EventList.add(
                    new Event.Builder(++eventCounter)
                            .withName(name)
                            .withDate(date)
                            .withLocation(location)
                            .build()
            );
            return eventCounter;
        }
        else return 0;
    }

    //finds and returns an event ID based on the event name
    private int findEvent(String name) {
        for (Event existingEvent : EventList) {
            if (existingEvent.getEventName().equals(name)) {
                return existingEvent.getID();
            }
        }
        return 0;
    }


    //displays an event in the form "<eventName> at <location> <date>"
    public void displayEvent() {
        if (EventList.isEmpty()) {
            System.out.println("No Events at current moment.");
        }
        for (Event existEvent : EventList) {
            System.out.print(existEvent.getID() + " ");
            System.out.print(existEvent.getEventName() + " at ");
            System.out.print(existEvent.getLocation() + " ");
            System.out.println(existEvent.getDate());
        }
    }

    public boolean joinEvent(int userIndex,int eventIndex) {
        if (userIndex < 0 || userIndex >= userCounter ||
        eventIndex<0 || eventCounter >= eventCounter) return false;
        UserList.get(userIndex-1).addEvent(EventList.get(eventIndex-1));
        EventList.get(eventIndex-1).addAttendee(UserList.get(userIndex-1));
        return true;
    }

    public User findUser(int index) {
        return UserList.get(index-1);
    }

    public Event findEvent(int index) {
        return EventList.get(index-1);
    }
}

