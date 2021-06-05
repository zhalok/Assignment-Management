import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

class Filehandle{
    
    int assignement_of;
    Filehandle(int assignment_of)
    {
        this.assignement_of = assignment_of;
    }

    void ReadandWriteFile() throws IOException
    {
     
      BufferedReader reader = new BufferedReader(new FileReader("submit_file.txt"));
      BufferedWriter writer = new BufferedWriter(new FileWriter("./assignments/assignment_of_"+assignement_of+".txt",true));
      String s;
      while((s=reader.readLine())!=null)
      writer.write(s+"\n");
      writer.write("\n");

      

      reader.close();
      writer.close();
      
    }


}



class Student {

    private String Name;
    private String Registration_number;
    private String Session;
    private String Department;
    private String Password;

    public String getName()
    {
        return this.Name;
    }

    public String getReg()
    {
        return this.Registration_number;
    }

    public String getSession()
    {
        return this.Session;
    }

    public String getDepartment()
    {
        return this.Department;
    }

    Student(String Name,String Registration_number,String Session,String Department,String password)
    {
       this.Name = Name;
       this.Registration_number = Registration_number;
       this.Session = Session;
       this.Department = Department;
       this.Password = password;
    }
    
    

}



class Authentification{

    int Login_as_Student(String reg,String pass) throws Exception
    {
         
         BufferedReader reader = new BufferedReader(new FileReader("./Amin/Students.txt"));
         String s;
         while((s=reader.readLine())!=null)
         {
             String[] words = s.split("\\s+");
             String registered_reg = words[0];
             String registered_pass = words[1];
             if(registered_reg.matches(reg)&&registered_pass.matches(pass)){
             reader.close();    
             return 1;
             }


         }

         reader.close();
         return 0;
      
       
    }

    void Login_as_Instructor(String reg,String pass)
    {

    }

    int Register_as_Student(String name,String reg,String dept,String session,String pass) throws Exception
    {
         BufferedWriter writer = new BufferedWriter(new FileWriter("./Amin/Student_Request.txt",true));
         String info = reg+" "+pass+" "+name+" "+dept+" "+session;
         BufferedReader reader = new BufferedReader(new FileReader("./Amin/Students.txt"));
         BufferedReader reader2 = new BufferedReader(new FileReader("./Amin/Student_Request.txt"));
         String str;
         while((str=reader.readLine())!=null)
         {
             String[] words=str.split("\\s+");
             String regg=words[0];
             if(regg.matches(reg))
             {
                //  System.out.println("User Already Registered");
                 reader.close();
                 return 0;
             }
         }
         reader.close();

         while((str=reader2.readLine())!=null)
         {
             String[] words=str.split("\\s+");
             String regg = words[0];
             if(regg.matches(reg))
             {
                 reader2.close();
                 return 0;
             }
         }
       
         reader2.close(); 

         writer.write(info+"\n");
         
         writer.close();
         return 1;

    }

    // void Register_as_instructor(Instructor instructor)
    // {

    // }

    

}

public class Main{
    public static void main(String[] args) {

       while(true)
       {

       System.out.println("Welcome to the terminal based application");
       System.out.println("Do u want to login? or register?");
       Scanner scanner = new Scanner(System.in);
       String decide = scanner.nextLine();
       int isLoggedin=0;
       if(decide.matches("Login")||decide.matches("login"))
       {
           System.out.println("Please provide your registration id");
           String reg = scanner.nextLine();
           System.out.println("Please provide your password");
           String pass = scanner.nextLine();
           Authentification authentification = new Authentification();
           try{
               int val = authentification.Login_as_Student(reg, pass);
               if(val==1){
                   isLoggedin=1;
                   System.out.println("Logged in Successfully");
               }
               else {
                   System.out.println("Credentials did not match do you want to try again?");
                   String tryagain=scanner.nextLine();
                   if(tryagain.matches("no")||tryagain.matches("No"))
                   return ;
               }

           }catch(Exception e)
           {
               System.out.println("Exception Occured");
               
           }
       }
       else if(decide.matches("register")||decide.matches("Register")) {
           System.out.println("Please provide your name");
           String name = scanner.nextLine().trim();
           System.out.println("Please provide your registration id");
           String reg = scanner.nextLine().trim();
           System.out.println("Please provide your department");
           String dept = scanner.nextLine().trim();
           System.out.println("Please provide your session");
           String session = scanner.nextLine().trim();
           System.out.println("Please provide a password");
           String pass = scanner.nextLine().trim();
           System.out.println("Confirm password");
           String confirm_pass = scanner.nextLine().trim();
           if(pass.matches(confirm_pass)){
               Authentification authentification = new Authentification();
               try{
               int val = authentification.Register_as_Student(name, reg, dept, session, pass);
               if(val==1){
               System.out.println("Successfully Requested");
               }
               else {
                System.out.println("User already registered");
               }
               System.out.println("Do u want to continute ?");
               String cont=scanner.nextLine();
               if(cont.matches("no")||cont.matches("No"))
               return ;
               
               

               
               }catch(Exception e)
               {
                   System.out.println("Exception occured");
               }
           }
           else {
              
               System.out.println("Passwords didnt match wanna try again?");
               String tryagain=scanner.nextLine().trim();
               if(tryagain.matches("no")||tryagain.matches("No")) break;
               

           }
           

       }
       else {
           System.out.println("Unknown Command");
           System.out.println("For logging in write Login or login");
           System.out.println("For registration write Register or register");
       }

       if(isLoggedin==1)
       {

       }

    }
}

}
