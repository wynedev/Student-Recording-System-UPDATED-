package NewSession;

public class section1 {
   private String fname,lname, email, course,section;

   section1(String fname,String lname, String email, String course, String section){
       this.fname = fname;
       this.lname = lname;
       this.email = email;
       this.course = course;
       this.section = section;
   }
   void introduce(){
       System.out.println("Name   : " + fname + " " + lname);
       System.out.println("Course : " + course + " " + section);
       System.out.println("Email  : " + email);
   }
   void censoredIntro(){
       System.out.println("Name   : " + fname + " *****");
       System.out.println("Course : " + course + " " + section);
       System.out.println("Email  : *****");
       System.out.println();
   }
   String getEmail(){
       return email;
   }
}
