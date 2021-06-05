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
    
    int verify() throws Exception
    {
        
    }

    void make_request()
    {
          
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
             String registered_red = words[0];
             String registered_pass = words[1];

         }
      
       
    }

    void Login_as_Instructor(String reg,String pass)
    {

    }

    void Register_as_Student(Student student)
    {

    }

    // void Register_as_instructor(Instructor instructor)
    // {

    // }

    

}

public class Main{
    public static void main(String[] args) {

       
}
