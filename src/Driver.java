public class Driver {
    public static void main(String[] args) {
        School newSchool = new School();
        newSchool.createUser("Student","John", "nopassword" );
        newSchool.login("John","nopassword");
    }
}
