package NewSession;
import java.util.ArrayList;
import java.util.Scanner;

//ArrayList //Student registration

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<section1> students = new ArrayList<section1>();

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
                case 1 -> {
                    studentlogin();
                }
                case 2 -> {
                    studentRegister();
                }
                case 3-> {
                    showStudents();
                }
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

        System.out.println("\n***** Student login *****");
        System.out.print("Enter email to login: ");
        email = sc.nextLine();

        System.out.println("Searching...");


        for(int i = 0; i < students.size(); i++){
            if(email.equals(students.get(i).getEmail())){
                System.out.println("\nAccount Found\n");

                isFound = true;

                System.out.println("Student number : " + (i + 1));
                students.get(i).introduce();

                System.out.println("[1] Delete Account");
                System.out.println("[2] Exit");

                System.out.print("\nEnter Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice){
                    case 1 -> {
                        students.remove(i);
                        System.out.println("Account has been deleted...");
                    }
                    case 2 -> {
                        break;
                    }
                }
            }
        }
        if(!isFound){
            System.out.println("\nAccount not found...\n");
        }
    }
    static void studentRegister(){
        String fname,lname,email,course,section;

        System.out.println("\n***** Register *****");

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
}