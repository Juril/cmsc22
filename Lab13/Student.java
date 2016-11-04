import java.io.Serializable;

/**
 * Created by Juril on 11/4/2016.
 */
public class Student implements Serializable{

    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private String crushName;
    private Course faveSubject;

    public void setStudentNumber(String studentNumber){
        this.studentNumber = studentNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }

    public Course getFaveSubject() {
        return faveSubject;
    }

    public void setFaveSubject(Course faveSubject) {
        this.faveSubject = faveSubject;
    }

    public String toString() {
        return String.format("Student Number: %s\nName: %s %c %s\nProgram: %s\nYear Level: %d\nCrush Name: %s\nFavorite Subject: %s\n", studentNumber, firstName, middleInitial, lastName, course, yearLevel, crushName, faveSubject);
    }

    public String getStudentNumber() {return studentNumber;}
    public String getFirstName() {return firstName;}
    public char getMiddleInitial() {return middleInitial;}
    public String getLastName() {return lastName;}
    public String getCourse() {return course;}
    public int getYearLevel() {return yearLevel;}
    public String getCrushName() {
        return crushName;
    }

    Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String crushName, Course faveSubject) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.crushName = crushName;
        this.faveSubject = faveSubject;
    }
}
