
/*Student class is a child of the abstract User class. This class also includes the student builder,
which facilitates the creation of new student
 */
public class Student extends User {
    public static String userType = "Student";
    private int studentID;
    private String major;


    //default constructor
    private Student() {
    }

    //builder for student.
    public static class Builder {
        private String name;
        private int ID;
        private String email;
        private int studentID;
        private String major;
        private String password;

        public Builder(int ID) {
            this.ID = ID;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder  withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withStudentID(int studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder withMajor (String major) {
            this.major = major;
            return this;
        }

        public Builder withPassword (String password) {
            this.password = password;
            return this;
        }

        //creates the new student
        public User build(){
            Student account = new Student();
            account.ID = this.ID;
            account.name = this.name;
            account.studentID = this.studentID;
            account.email = this.email;
            account.major = this.major;
            account.password = this.password;
            return account;
        }
    }

    //returns the student's ID # as an int
    public int getStudentID() {
        return studentID;
    }
    //sets the student's ID # to an int
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    //overrides the toString() method
    @java.lang.Override
    public java.lang.String toString() {
        return  userType +
                "\n Name: " + name + "\n" +
                "student ID: " + ID + "\n" +
                "Email='" + email + '\n';
                //"EventList=" + eventList +'\n'+
                //"GroupList=" + groupList + '\n';
    }

}