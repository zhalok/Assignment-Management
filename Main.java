import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

interface Features{

    void ReadandWriteFileforAssignments();
    void ReadandWriteFileforResults();
    int Login_as_Student();
    int Login_as_Instructor();
    int Register_as_Student();
    int Register_as_Instructor();



}

class Adapter implements Features{
    public void ReadandWriteFileforAssignments(){}
    public void ReadandWriteFileforResults(){}
    public int Login_as_Student(){ return 0; }
    public int Login_as_Instructor(){ return 0; }
    public int Register_as_Student(){ return 0; }
    public int Register_as_Instructor(){ return 0; }
}

class Filehandle extends Adapter{
    
   

    public void ReadandWriteFileforAssignments(int assignement_of) throws IOException
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

    public void ReadandWriteFileforResults(int result_of) throws Exception{

        BufferedReader reader = new BufferedReader(new FileReader("submit_assignment.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("./published_results/assignment_of_"+result_of+".txt",true));
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

    public String getPassword()
    {
        return this.Password;
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


class Instructor{
    private String Name,Department,Session,Registration_id,Password;
    Instructor(String name,String department,String registration_id,String password,String session)
    {
       this.Name=name;
       this.Department=department;
       this.Session=session;
       this.Registration_id=registration_id;
       this.Password=password;



    }

    public String getName()
    {
        return Name;
    }

    public String getSession(){
        return Session;
    }

    public String getDepartment()
    {
        return Department;
    }

    public String getRegistration ()
    {
        return Registration_id;
    }

    public String getPassword()
    {
        return Password;
    }

    

}



class Authentification extends Adapter{

    public int Login_as_Student(String reg,String pass) throws Exception
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

    public int Login_as_Instructor (String reg,String pass) throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader("./Amin/Instructors.txt"));
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

    public int Register_as_Student(Student student) throws Exception
    {
         String name,reg,dept,session,pass;
         name=student.getName();
         reg=student.getReg();
         pass=student.getPassword();
         dept=student.getDepartment();
         session=student.getSession();

         BufferedWriter writer = new BufferedWriter(new FileWriter("./Amin/Student_Request.txt",true));
         String info = reg+" "+pass+" "+name+" "+dept+" "+session;
         BufferedReader reader = new BufferedReader(new FileReader("./Amin/Students.txt"));
         BufferedReader reader2 = new BufferedReader(new FileReader("./Amin/Student_Request.txt"));
         String str;
         while((str=reader.readLine())!=null)
         {
             String[] words=str.split("\\s+");
             String regg=words[0];
             String ddept = words[words.length-2];
             String ssession = words[words.length-1];
             if(regg.matches(reg)&&ddept.matches(dept)&&ssession.matches(session))
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

    public int Register_as_instructor(Instructor instructor) throws Exception
    {
        String name,reg,dept,session,pass;
        name = instructor.getName();
        reg = instructor.getRegistration();
        session = instructor.getSession();
        pass =  instructor.getPassword();
        dept = instructor.getDepartment();

        BufferedWriter writer = new BufferedWriter(new FileWriter("./Amin/Instructor_Request.txt",true));
        String info = reg+" "+pass+" "+name+" "+dept+" "+session;
        BufferedReader reader = new BufferedReader(new FileReader("./Amin/Instructors.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("./Amin/Instructor_Request.txt"));
        String str;
        while((str=reader.readLine())!=null)
        {
            String[] words=str.split("\\s+");
            String regg=words[0];
            String ddept = words[words.length-2];
            String ssession = words[words.length-1];
            if(regg.matches(reg)&&ddept.matches(dept)&&ssession.matches(session))
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

    

}

public class Main{
   
    public static void main(String[] args) {
      

       while(true)
       {

     

       System.out.println("Welcome to the terminal based application");
       System.out.println("Do u want to login? or register?");
       Scanner scanner = new Scanner(System.in);
       String decide = scanner.nextLine();
       int isLoggedin=0;  // 0 for no one , 1 for student, 2 for instructor
       int loggedinStudentID=0;
       int loggedinInstructorID=0;
       if(decide.matches("Login")||decide.matches("login"))
       {
           System.out.println("Are you a student or and Instructor?");
           String type = scanner.nextLine();
           if(type.matches("student")||type.matches("Student")){

           System.out.println("Please provide your registration id");
           int reg = scanner.nextInt();
           System.out.println("Please provide your password");
           String pass = scanner.nextLine();
           Authentification authentification = new Authentification();
           try{
               int val = authentification.Login_as_Student(Integer.toString(reg), pass);
               if(val==1){
                   isLoggedin=1;
                   loggedinInstructorID=reg;
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

        else if(type.matches("Instructor")||type.matches("instructor"))
        {
             int instructor_reg = scanner.nextInt();
             String password = scanner.nextLine();
             Authentification authentification = new Authentification();
             try{
              int val = authentification.Login_as_Instructor(Integer.toString(instructor_reg), password);
              if(val==1)
              {
                  isLoggedin=2;
                  loggedinInstructorID=instructor_reg;

              }
             }catch(Exception e)
             {
                 System.out.println(e);
             }
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

               System.out.println("Do you want to register as a student or as an instructor?");

               String decision = scanner.nextLine();
               
               Authentification authentification = new Authentification();
               try{
               
                if(decision.matches("student")||decision.matches("Student")){

               Student student = new Student(name, reg, session, dept, pass);
               int val = authentification.Register_as_Student(student);
               if(val==1){
               System.out.println("Successfully Requested");
               }
               else {
                System.out.println("User already registered");
               }

            }

            else {
                Instructor instructor = new Instructor(name, reg, session, dept, pass);
                int val = authentification.Register_as_instructor(instructor);
                if(val==1){
                System.out.println("Successfully Requested");
                }
                else {
                 System.out.println("User already registered");
                }
 
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
               if(tryagain.matches("no")||tryagain.matches("No")) return ;
               

           }
           

       }
       else {
           System.out.println("Unknown Command");
           System.out.println("For logging in write Login or login");
           System.out.println("For registration write Register or register");
       }

       if(isLoggedin==1)
       {
            
             System.out.println("You are Logged in as a student");
             System.out.println("Do you want to submit an assignment ?");
             String ans = scanner.nextLine();
             if(ans.matches("Yes")||ans.matches("yes"))
             {
                 System.out.println("Please write your assignment in the submit.txt file then write submit");
                 String submit = scanner.nextLine();
                 if(submit.matches("submit")||submit.matches("submit"))
                 {
                     Filehandle filehandle = new Filehandle();
                     try{
                         filehandle.ReadandWriteFileforAssignments(loggedinStudentID);
                     }catch(Exception e)
                     {
                         System.out.println(e);
                     }

                 }
             }
             

       }
       else if(isLoggedin==2)
       {
           System.out.println("Logged in as an instructor! ");
           System.out.println("Do u want to give marks ?");
           System.out.println("Please submit the result in the result folder and then press any key");
           scanner.nextLine();
           Filehandle filehandle = new Filehandle();
           try{

            filehandle.ReadandWriteFileforResults(loggedinInstructorID);

           }catch(Exception e)
           {
               System.out.println("File not found");
           }
           

            
       }

    }
}

}
