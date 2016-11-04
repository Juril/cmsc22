/**
 * Created by Juril on 11/4/2016.
 */
import java.io.*;
import java.util.*;

public class ListTest implements Serializable {

    public static void main(String[] args) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        List<Student> savedList = new ArrayList<Student>();
        int choice;
        String firstName, lastName, course, midInitial,studentNumber, crushName;
        Course faveSubject, courseCode, courseDescription;
        char middleInitial;
        int year;
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        try {
            File fin = new File("C:\\Users\\Juril\\Digamon\\II\\CMSC 22\\Lab13\\db.txt");
            if (!fin.exists()) {
                fin.createNewFile();
            }
            fis = new FileInputStream(fin);
            if(fin.length() == 0) {
            }
            else{
                ois = new ObjectInputStream(fis);
                savedList = ( ArrayList<Student>) ois.readObject();
            }
        } catch (IOException e) {
            // standard file handling exception
            e.printStackTrace();
        } catch (ClassNotFoundException ce) {
            // this might be thrown by ois.readObject()
            ce.printStackTrace();
        } catch (NullPointerException x)  {
            x.printStackTrace();
        }
        finally {
            // make sure to close the files!
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        do{
            System.out.println("1. Register a student");
            System.out.println("2. Search a student");
            System.out.println("3. Remove a student");
            System.out.println("4. Save your work");
            System.out.println("5. Update a student");
            System.out.println("6. Display student database");
            System.out.println("7. Exit");
            choice = sc.nextInt();
            if(choice == 1) {
                //reg
                register(savedList);
            } else
            if(choice == 2) {
                //search
                System.out.println("Enter student number: ");
                studentNumber = sc.next();
                if(!search(studentNumber, savedList)) {
                    System.out.println("Student does not exist!	");
                }
            } else
            if(choice == 3) {
                //delete
                System.out.println("Enter student's student number to delete: ");
                studentNumber = sc.next();
                if(delete(studentNumber, savedList)) {
                    System.out.println("Student deleted!");
                } else {
                    System.out.println("No Student exists");
                }
            } else
            if(choice == 4) {
                //save
                System.out.println("Saving your work...");
                sleep(3000);
                save(savedList, fos, oos);
                System.out.println("Saved Successfully!");
            } else
            if(choice == 5) {
                //edit
                edit(savedList);
            } else
            if(choice == 6) {
                for(Student s: savedList) {
                    System.out.println(s);
                }
            }else
            if(choice == 7) {
                //exit
                System.out.println("Do you want to save your work?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int choose = sc.nextInt();
                if(choose == 1){
                    System.out.println("Saving your work...");
                    sleep(3000);
                    save(savedList, fos, oos);
                    System.out.println("Saved Successfully!");
                }
                System.out.println("Exiting...");
            }
            sleep(2000);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }while(choice!=7);

    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void register(List<Student> myList) {
        String fName, mName, lName, program, studNo, crushName, crsCode, crsDesc;
        Course faveSubject;
        char mid;
        int yLevel;
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        Scanner read = new Scanner(System.in);
        System.out.println("Student Number: ");
        studNo = sc.next();
        check = search(studNo, myList);
        if(!check){
            System.out.println("First Name: ");
            fName = sc.nextLine();
            fName = sc.nextLine();
            System.out.println("Middle Initial: ");
            mName = sc.next();
            if(mName.equals("")) {
                mid = 32;
            }else {
                mid = mName.charAt(0);
            }
            System.out.println("Last Name: ");
            lName = sc.nextLine();
            lName = sc.nextLine();
            System.out.println("Program: ");
            program = sc.nextLine();
            System.out.println("Year Level: ");
            yLevel = read.nextInt();
            System.out.println("Crush Name: ");
            crushName = sc.nextLine();
            System.out.println("Favorite Course Name: ");
            crsCode = sc.nextLine();
            System.out.println("Course Description of your Favorite Course: ");
            crsDesc = sc.nextLine();
            Student a = new Student(studNo,fName,mid,lName,program,yLevel,crushName, new Course(crsCode, crsDesc) );
            myList.add(a);

            System.out.println("Student added!");
        } else {
            System.out.println("Student already registered!");
        }
    }

    public static boolean search(String studNum, List<Student> myList) {
        for(Student s: myList) {
            if(s.getStudentNumber().equals(studNum)) {
                System.out.println(s);
                return true;
            }
        }
        return false;
    }

    public static boolean delete(String studNum, List<Student> myList) {
        for(Student s: myList) {
            if(s.getStudentNumber().equals(studNum)) {
                myList.remove(s);
                return true;
            }
        }
        return false;
    }

    public static void save(List<Student> myList, FileOutputStream fos, ObjectOutput oos) {
        try {
            File fout = new File("C:\\Users\\Juril\\Digamon\\II\\CMSC 22\\Lab13\\db.txt");
            if (!fout.exists()) {
                fout.createNewFile();
            }
            fos = new FileOutputStream(fout);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(myList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void edit(List<Student> myList) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String studentNumber;
        int choice;
        System.out.println("Enter Student Number: ");
        studentNumber = sc.next();
        for(Student s: myList) {
            if(s.getStudentNumber().equals(studentNumber)) {
                System.out.println("What will you edit?");
                System.out.println("1. Name");
                System.out.println("2. Program");
                System.out.println("3. Year Level");
                System.out.println("4. Crush Name");
                System.out.println("5. Favorite Subject");
                choice = sc.nextInt();
                if(choice == 1) {
                    System.out.println("Enter new First Name: ");
                    s.setFirstName(sc.nextLine());
                    System.out.println("Enter new Middle Initial: ");
                    s.setMiddleInitial(sc.next().charAt(0));
                    System.out.println("Enter new Last Name: ");
                    s.setLastName(sc.nextLine());
                }else
                if(choice == 2) {
                    System.out.println("Enter new Program: ");
                    s.setCourse(sc1.nextLine());
                }else
                if(choice == 3) {
                    System.out.println("Enter new Year Level: ");
                    s.setYearLevel(sc2.nextInt());
                }else
                if(choice == 4) {
                    System.out.println("Enter new Crush Name: ");
                    s.setCrushName(sc2.nextLine());
                }else
                if(choice == 5) {
                    System.out.println("Enter new Favorite Subject: ");
                    s.getFaveSubject().setCourseCode(sc2.nextLine());
                    System.out.println("Enter new Favorite Subject Description: ");
                    s.getFaveSubject().setCourseDescription(sc2.nextLine());
                }
                break;
            }else {
                System.out.println("Student not found");
                break;
            }
        }
    }

}
