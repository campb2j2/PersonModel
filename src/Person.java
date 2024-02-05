import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private final String ID;
    private String title;
    private int YOB;

    // Constructor
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    // Additional methods
    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        return getAge(Calendar.getInstance().get(Calendar.YEAR));
    }

    public int getAge(int year) {
        return year - YOB;
    }

//method to convert to CSV format
    public String toCSVDataRecord() {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }

    // Method to convert to JSON format
    public String toJSONDataRecord() {
        String retString = "";
        char DQ = '\u0022'; // Double quote character
        retString += DQ + "firstName" + DQ + ":" + DQ + firstName + DQ + ",";
        retString += DQ + "lastName" + DQ + ":" + DQ + lastName + DQ + ",";
        retString += DQ + "ID" + DQ + ":" + DQ + ID + DQ + ",";
        retString += DQ + "title" + DQ + ":" + DQ + title + DQ + ",";
        retString += DQ + "YOB" + DQ + ":" + YOB;
        return retString;
    }

}
