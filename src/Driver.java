import java.util.Scanner;

public class Driver {
	
    public static void main(String[] args) {

    	//creates an empty UserList
        School newSchool = new School();

        System.out.println("Would you like to login or create a new account?");
        System.out.println("If you would like to login, please type 'login'");
        System.out.println("If you would like to create a new account, please type 'create'");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String email = "random";
        String password;

        boolean confirmed = false;


        while(!(input.equals("create") || input.equals("login")))
        {
            System.out.println("Please enter 'create' or 'login'");
            input = scanner.nextLine();
        }

        if(input.equals("create")) {
        	input = scanner.nextLine();
        	while(!confirmed) {
                System.out.println("Please enter your email: ");
                email = scanner.nextLine();
                System.out.println("You entered: " + email + ". Is this correct? [Y|N]");
                input = scanner.nextLine();

                if (!(input.equals("Y") || input.equals("N") || input.equals("yes") || input.equals("no")
                        || input.equals("y") || input.equals("n"))) {
                    System.out.println("Please enter 'yes' or 'no'");
                }
                if (input.equals("yes") || input.equals("y")) {
                    confirmed = true;
                }
            }
        	confirmed = false;

            while(!confirmed) {
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                System.out.println("You entered: " + password + ". Is this correct? [Y|N]");
                input = scanner.nextLine();

                if (!(input.equals("Y") || input.equals("N") || input.equals("yes") || input.equals("no")
                        || input.equals("y") || input.equals("n"))) {
                    System.out.println("Please enter 'yes' or 'no'");
                }
                if (input.equals("yes") || input.equals("y")) {
                    confirmed = true;
                }

                newSchool.createUser("Student",email, password);
                newSchool.login(email, password);
                System.out.println("Great! You are logged in with your new account!");
            }
        }
        else if(input.equals("login"))
        {
            System.out.println("Please enter your email: ");
            email = scanner.nextLine();
            System.out.println("Please enter your password: ");
            password = scanner.nextLine();
            newSchool.login(email, password);

        }
        System.out.println("What would you like to do? Enter 'help' for list of options. Enter 'quit' if you would like" +
                "to exit the program");
        input = scanner.nextLine();
        while(!input.equals("quit"))
        {
            if(input.equals("help"))
            {
                System.out.println("'create event' -- allows you to create a new event.\n" +
                        "'show events' -- shows a list of upcoming events. \n" +
                        "'create group' --allows you to create a study group. \n" +
                        "'see groups -- allows you to see recommended study groups.");
            }
            if(input.equals("'create event"))
            {

            }
            input = scanner.next();
        }
//        //createUser called in the School.java
//        newSchool.createUser("Student","John", "nopassword" );
//        newSchool.login("John","nopassword");
//        newSchool.createUser("Student","Kelly Johnson", "kelly" );
//        newSchool.createUser("Student","Harry", "harry");
//        newSchool.createUser("Student","Yamato", "yamato");
//        newSchool.login("Kelly Johnson","nopassword");
//        newSchool.login("haha","nopassword");
//        newSchool.login("Harry","harry");
    }
}
