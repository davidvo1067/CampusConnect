import java.util.Scanner;

public class Driver {
	
    public static void main(String[] args) {

    	//creates an empty UserList
        int currentUser = -1;
        School newSchool = new School();

        System.out.println("Would you like to login or create a new account?");
        System.out.println("If you would like to login, please type 'login'");
        System.out.println("If you would like to create a new account, please type 'create'");

        Scanner scanner = new Scanner(System.in);

        String input;
        String email = "random";
        String password = "";

        boolean confirmed = false;


        do
        {
            System.out.println("Please enter 'create' or 'login'");
            input = scanner.nextLine();
        } while (!(input.equals("create") || input.equals("login")));


        if(input.equals("create")) {
        	input = scanner.nextLine();
        	while(!confirmed) {
                System.out.println("Please enter your email: ");
                email = scanner.nextLine();
                System.out.println("You entered: " + email + ". Is this correct? [Y|N]");
                input = scanner.nextLine();

                if (!(input.toUpperCase().equals("Y") || input.toUpperCase().equals("N")
                    || input.toLowerCase().equals("yes") || input.toLowerCase().equals("no")  )) {
                    System.out.println("Please enter 'Y' or 'N'");
                }

                if (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y")) {
                    confirmed = true;
                }
            }
        	confirmed = false;

            while(!confirmed) {
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                System.out.println("You entered: " + password + ". Is this correct? [Y|N]");
                input = scanner.nextLine();

                if (!(input.toUpperCase().equals("Y") || input.toUpperCase().equals("N")
                        || input.toLowerCase().equals("yes") || input.toLowerCase().equals("no")  )) {
                    System.out.println("Please enter 'Y' or 'N'");
                }

                if (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y")) {
                    confirmed = true;
                }

            }
            newSchool.createUser("Student",email, password);
            newSchool.login(email, password);
            System.out.println("Great! You are logged in with your new account!");
            currentUser = newSchool.login(email, password);
        }
        else if(input.equals("login"))
        do
        {
            System.out.println("Please enter your email or enter quit to quit:");
            email = scanner.nextLine();
            if (email.equals("quit")) break;
            System.out.println("Please enter your password: ");
            password = scanner.nextLine();
            currentUser = newSchool.login(email, password);

        } while (currentUser < 1 || email == "quit");


        if (currentUser > 0 ) {

            while(!input.equals("quit")) {
                System.out.println("What would you like to do? Enter 'help' for list of options. Enter 'quit' if you would like" +
                        "to exit the program");
                input = scanner.nextLine();
                if(input.equals("help")) {
                    System.out.println("'create event' -- allows you to create a new event.\n" +
                            "'show events' -- shows a list of upcoming events. \n" +
                            "'create group' --allows you to create a study group.");
                }
                if(input.equals("create event")) {
                    System.out.println("Please enter the event name: ");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the event date: ");
                    String date = scanner.nextLine();
                    System.out.println("Please enter the event location: ");
                    String location = scanner.nextLine();
                    int status = newSchool.createEvent(name,date,location);
                    if (status == 0) System.out.println("Event already exist");
                    else {
                        //System.out.println("Your event is created. Here is the information:");
                        //System.out.println(EventList[status]);
                    }
                }
                if(input.equals("show events")) {
                    newSchool.displayEvent();
                }
            }
        }

//        //createUser called in the School.javav
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
