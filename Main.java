package NewSession;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<section1> students = new ArrayList<>();

    public static void main(String[] args) {

        boolean isRunning = true;
        int choice;

        do{
            System.out.println("########################################");
            System.out.println("#        STUDENT REGISTRATION SYS      #");
            System.out.println("########################################");
            System.out.println("#  (1) Login                           #");
            System.out.println("#  (2) Register                        #");
            System.out.println("#  (3) Show Registrations              #");
            System.out.println("#  (4) Exit                            #");
            System.out.println("########################################");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> studentlogin();
                case 2 -> studentRegister();
                case 3-> showStudents();
                case 4 -> {
                    System.out.println("You've exited the program...");
                    isRunning = false;
                }
            }
        }while(isRunning);
    }

    static void showStudents() {

        if(students.isEmpty()){
            System.out.println("\nNo registration has been made...\n");
        }else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println("Student no." + (i + 1));
                students.get(i).censoredIntro();
            }
        }
    }
    static void studentlogin(){

        String email;
        boolean isFound = false;

        System.out.println("\n###### Student login ######");
        System.out.print("Enter email to login: ");
        email = sc.nextLine();

        System.out.println("Searching...");


        for(int i = 0; i < students.size(); i++){
            if(email.equals(students.get(i).getEmail())){
                System.out.println("\nAccount Found\n");

                isFound = true;

                System.out.println("Student number : " + (i + 1));
                students.get(i).introduce();

                System.out.println();
                System.out.println("[1] Delete Account");
                System.out.println("[2] Edit information");
                System.out.println("[3] Exit");

                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice){
                    case 1 -> {
                        students.remove(i);
                        System.out.println("\nAccount has been deleted...\n");
                        return;
                    }
                    case 2 -> editInfo(i);
                    case 3 -> {return;}
                }
            }
        }
        if(!isFound){
            System.out.println("\nAccount not found...\n");
        }
    }
    static void studentRegister(){
        String fname,lname,email,course,section;

        System.out.println("\n###### Register ######");

        System.out.print("First name : ");
        fname = sc.nextLine();

        System.out.print("Last name  : ");
        lname = sc.nextLine();

        System.out.print("Course     : ");
        course = sc.nextLine();

        System.out.print("Section    : ");
        section = sc.nextLine();

        System.out.print("Email      : ");
        email = sc.nextLine();

        boolean IsValid = false;

        IsValid = checkEmail(email);

        if(IsValid){
            students.add(new section1(fname,lname,email,course,section));
            System.out.println("Registration Complete\n");
        }
    }
    static boolean checkEmail(String email) {
        if(email.endsWith("@gmail.com")){
            return true;
        }
        else{
            System.out.println("Invalid Email...");
            return false;
        }
    }
    static void editInfo(int i){
        int choice;

        System.out.println("\n###### Edit Information ######");
        System.out.println("[1] Name");
        System.out.println("[2] Course");
        System.out.println("[3] Section");
        System.out.println("[4] Email");
        System.out.print("Select info to edit: ");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice){
            case 1 -> {
                System.out.print("Enter new first name: ");
                String fname = sc.nextLine();
                System.out.print("Enter new last name: ");
                String lname = sc.nextLine();

                students.get(i).setFname(fname);
                students.get(i).setLname(lname);

                System.out.println("\nName Updated!!!\n");
            }
            case 2 -> {
                System.out.print("Enter new course: ");
                String course = sc.nextLine();

                students.get(i).setCourse(course);

                System.out.println("\nCourse updated!!!\n");
            }
            case 3 -> {
                System.out.print("Enter new section: ");
                String section = sc.nextLine();

                students.get(i).setSection(section);

                System.out.println("\nSection has been updated!!!\n");
            }
            case 4 -> {
                boolean isRunning = true;

                do{
                    System.out.print("Enter new email: ");
                    String email = sc.nextLine();

                    boolean valid = false;

                    valid = checkEmail(email);

                    if(valid){
                        System.out.println("Valid Email!!");
                        students.get(i).setEmail(email);
                        System.out.println("\nEmail has been updated!!!\n");
                        isRunning = false;
                    }
                    else{
                        System.out.println("\nInvalid email!!!\n");
                    }
                }while(isRunning);
            }
        }
    }
}
