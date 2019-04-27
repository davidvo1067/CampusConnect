
/*Student class is a child of the abstract User class. This class also includes the student builder,
which facilitates the creation of new student
 */
public class Professor extends User {
    public static String userType = "Professor";
    private int employeeID;
    private String department;
    private boolean confirmed;


    //default constructor
    private Professor() {
    }

    //builder for Professor
    public static class Builder {
        private String name;
        private int ID;
        private String email;
        private int employeeID;
        private String department;
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

        public Builder withEmployeeID(int employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder withDepartment (String department) {
            this.department = department;
            return this;
        }

        public Builder withPassword (String password) {
            this.password = password;
            return this;
        }

        //creates the new Professor
        public User build(){
            Professor account = new Professor();
            account.ID = this.ID;
            account.name = this.name;
            account.employeeID = this.employeeID;
            account.email = this.email;
            account.department = this.department;
            account.password = this.password;
            account.confirmed =  false;
            return account;
        }
    }

    //returns the Professor's employeeID # as an int
    public int getEmployeeID() {
        return employeeID;
    }
    //sets the Professor's ID # to an int
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    //overrides the toString() method
    @java.lang.Override
    public java.lang.String toString() {
        String returnString = userType +
                "\n Name: " + name + "\n" +
               //"Department: " + department +"\n" +
                " ID: " + ID + "\n" +
                "Email='" + email + '\n' +
                "Confirmed Professor: " ;
        if(confirmed== false) {
            returnString+= "false"+ '\n';
        }
        else{
            returnString += "true";
        }
        return returnString;
        //"EventList=" + eventList +'\n'+
        //"GroupList=" + groupList + '\n';
    }



}