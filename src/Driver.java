public class Driver {
    public static void main(String[] args) {
      //creates an empty UserList 
        School newSchool = new School();
        newSchool.createUser("Student","John", "nopassword" );
        newSchool.login("John","nopassword");
        newSchool.createUser("Student","Kelly Johnson", "kelly" );
        newSchool.createUser("Student","Harry", "harry");
        newSchool.createUser("Student","Yamato", "yamato");
        newSchool.login("Kelly Johnson","nopassword");
        newSchool.login("haha","nopassword");
        newSchool.login("Harry","harry");


    }
}
