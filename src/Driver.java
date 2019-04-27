import java.util.Scanner;


/*This is the driver file. It first asks the user to either login or create an account. If the user decides
to create an account, they are automatically logged in. After that, the user can decide to create events, search for
events, or create a study group. We are working on getting it hooked up to the website that we created using php.
 */
public class Driver {

    //start program
    public static void main(String[] args) {

        int currentUser = -1;

        //creates an empty UserList
        School newSchool = new School();

        //Prompt for creating or logging into an account.
        System.out.println("Would you like to login or create a new account?");
        System.out.println("If you would like to login, please type 'login'");
        System.out.println("If you would like to create a new account, please type 'create'");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String email = "random";
        String password = "";
        String name = "";
        String userType = "";

        //confirmation for creating the username and password
        boolean confirmed = false;

        while (!(input.equals("create") || input.equals("login")))
        {
            System.out.println("Please enter 'create' or 'login'");
            input = scanner.nextLine();
        };

        //creating a new user account
        if(input.equals("create")) {

            System.out.println("Are you a student or a professor?");
            input = scanner.nextLine();
            while (!(input.toLowerCase().equals("student") || input.toLowerCase().equals("professor")))
            {
                System.out.println("Please enter 'student' or 'professor'");
                input = scanner.nextLine();
            };
            userType = input;
        	//for creating and confirming name
            while(!confirmed) {
                System.out.println("Please enter your name: ");
                name = scanner.nextLine();
                System.out.println("You entered: " + name + ". Is this correct? [Y|N]");
                input = scanner.nextLine();

                if (!(input.toUpperCase().equals("Y") || input.toUpperCase().equals("N")
                        || input.toLowerCase().equals("yes") || input.toLowerCase().equals("no")  )) {
                    System.out.println("Please enter 'Y' or 'N'");
                }

                if (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y")) {
                    confirmed = true;
                }
            }

            confirmed = false;//reset confirmed
            //for creating and confirming email
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

        	//for creating and confirming password
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

            //calls the createUser method from within the School class
            newSchool.createUser(userType,name, email, password);
            //logs in the new user
            currentUser = newSchool.login(email, password);
            System.out.println("Great! You are logged in with your new account!");
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
                        " to exit the program");
                input = scanner.nextLine();
                if(input.equals("help")) {
                    System.out.println("'create event' -- allows you to create a new event.\n" +
                            "'show events' -- shows a list of upcoming events. \n" +
                            "'join event (event name)' --allows you to join an event with the event ID");
                }
                if(input.equals("create event")) {
                    System.out.println("Please enter the event name: ");
                    String eventName = scanner.nextLine();
                    System.out.println("Please enter the event date: ");
                    String date = scanner.nextLine();
                    System.out.println("Please enter the event location: ");
                    String location = scanner.nextLine();
                    int status = newSchool.createEvent(eventName,date,location);
                    if (status == 0) System.out.println("Event already exist");
                    else {
                        //System.out.println("Your event is created. Here is the information:");
                        //System.out.println(EventList[status]);
                    }
                }
                if(input.equals("show events")) {
                    newSchool.displayEvent();
                }
                if (input.equals("join events")) {
                    System.out.println("Please enter the event ID to join ");
                    input = scanner.nextLine();
                    int eventID = Integer.parseInt(input);
                    if (newSchool.joinEvent(currentUser,eventID)) {
                    }
                    else {
                        System.out.println("Error in joining the event.");
                    }


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
