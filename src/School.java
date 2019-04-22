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
        System.out.println("Start creating user....");
        if (findUser(email) == 0) {
            if (userType.equals("Student")) {
                UserList.add(
                        new Student.Builder(++counter)
                                .withEmail(email)
                                .withPassword(password)
                                .build()
                );
                System.out.println("Created Student complete");
                return true;
            }
        }
        else {

            return false;
        }
        return false;
    }

    public int login(String email, String password) {
        System.out.println("Start login process");
        int userID = findUser(email);
        if (userID != 0L) {
            if (UserList.get(userID-1).getPassword().equals(password)) {
                System.out.println(UserList.get(userID-1).toString());
                return userID;
            }
        }
        else {
            System.out.println("Log in failure");
            return 0;
            }
        return 0;
    }

    private int findUser(String email) {

        for (CampusConnect.User existUser: UserList) {
            System.out.print(existUser.getEmail() + " ");
            if (existUser.getEmail().equals(email)) {
                return existUser.getID();
            }
        }
        return 0;
    }



}
