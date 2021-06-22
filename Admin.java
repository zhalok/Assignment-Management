

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class Admin {
    void authentify_Students() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader("Student_Request.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("Students.txt",true));
        String s;
        while((s=reader.readLine())!=null)
        writer.write(s+"\n");
        writer.write("\n");
  
        
  
        reader.close();
        writer.close();
    }
    void authentify_Instructors() throws Exception{

        BufferedReader reader = new BufferedReader(new FileReader("Instructor_Request.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("Instructors.txt",true));
        String s;
        while((s=reader.readLine())!=null)
        writer.write(s+"\n");
        writer.write("\n");
  
        
  
        reader.close();
        writer.close();
        
    }
    public static void main(String[] args) {
        Admin admin = new Admin();
       
        while(true)
        {

        System.out.println("Hello Admin what do you want to do ? ");
        System.out.println("Press 1 to authentify students");
        System.out.println("Press 2 to authentify instructors");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        
        if(x==1)
        {
            try{
                
                admin.authentify_Students();
                System.out.println("Students are authentified now please check the student lists");
                System.out.println("Do u want to continiue?");
                Scanner scanner2 = new Scanner(System.in);
                String msg = scanner2.nextLine();
                if(msg.matches("No")||msg.matches("no"))
                {
                    return ;
                }
                

            }catch(Exception e)
            {
                System.out.println("File not found");
            }
        }else if(x==2)
        {
            try{
                admin.authentify_Instructors();
                System.out.println("Instructors are authentified");
                System.out.println("Do u want to continute?");
                Scanner scanner2 = new Scanner(System.in);
                String msg = scanner2.nextLine();
                if(msg.matches("No")||msg.matches("no"))
                {
                    return ;
                }
                
            }catch(Exception e)
            {
                System.out.println("File not found");
            }
        }
     }

    }
}
