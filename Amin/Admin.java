package Amin;

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
}
