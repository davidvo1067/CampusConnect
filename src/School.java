import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.println;

public class School {
    public int userCounter = 0;
    public int eventCounter = 0;
    private List<User> UserList;
    private List<Event> EventList;

    public School() {
        UserList = new ArrayList();
        EventList = new ArrayList();
        createUser("Student","John", "nopassword" );
        createUser("Student","Kelly Johnson", "kelly" );
        createUser("Student","Harry", "harry");
        createUser("Student","Yamato", "yamato");
    }

    public int createUser(String userType, String email, String password) {
        System.out.println("Register status: ");
        int userID = findUser(email);
        if (userID == 0) {
            if (userType.equals("Student")) {
                UserList.add(
                        new Student.Builder(++userCounter)
                                .withEmail(email)
                                .withPassword(password)
                                .build()
                );
                System.out.println("Created " + email + "  Student complete \n");
                return userID ;
            }
        } else {
            System.out.println("User already exist \n");
            return 0;
        }
        return 0;
    }

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

    private int findUser(String email) {

        for (User existUser : UserList) {
            if (existUser.getEmail().equals(email)) {
                return existUser.getID();
            }
        }
        return 0;
    }

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


    private int findEvent(String name) {
        for (Event existEvent : EventList) {
            if (existEvent.getEventName().equals(name)) {
                return existEvent.getID();
            }
        }
        return 0;
    }

    public void displayEvent() {
        if (EventList.isEmpty()) {
            System.out.println("No Events at current moment.");
        }
        for (Event existEvent : EventList) {
            System.out.println(existEvent.getEventName());
        }
    }


}

