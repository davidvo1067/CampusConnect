import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.println;

public class School {
    public static int counter = 0;
    private List<CampusConnect.User> UserList;


    public School() {
        UserList = new ArrayList();
    }

    public boolean createUser(String userType, String email, String password) {
        System.out.println("Register status: ");
        if (findUser(email) == 0) {
            if (userType.equals("Student")) {
                UserList.add(
                        new Student.Builder(++counter)
                                .withEmail(email)
                                .withPassword(password)
                                .build()
                );
                System.out.println("Created " + email + "  Student complete \n" );
                return true;
            }
        }
        else {
            System.out.println("User already exist \n" );
            return false;
        }
        return false;
    }

    public int login(String email, String password) {
        System.out.println("Start login process");
        int userID = findUser(email);
        if (userID != 0L) {
            if (UserList.get(userID-1).getPassword().equals(password)) {
                System.out.println("Log in success:");
                System.out.println("--------" + email + "'s profile----");
                System.out.println(UserList.get(userID-1).toString());
                System.out.println("--------------------- \n");
                return userID;
            }
            else {
                System.out.println("Log in failure: wrong password+ \n");
                return 0;
            }
        }
        else {
            System.out.println("Log in failure: the email is not exist in the system + \n");
            return 0;
            }
    }

    private int findUser(String email) {

        for (CampusConnect.User existUser: UserList) {
            if (existUser.getEmail().equals(email)) {
                return existUser.getID();
            }
        }
        return 0;
    }



}
