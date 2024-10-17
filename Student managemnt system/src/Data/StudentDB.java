/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.File;
import Data.Student;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DSYS
 */
public class StudentDB implements Istudent{
    File file=new File("D:\\StudentDetails.txt");
    Student student;

    @Override
    public boolean insert(Student student) {
        try {
            FileWriter filewrite=new FileWriter(file,true);
            filewrite.write(student.getFirstName()+":"+
                    student.getLastName()+":"+
                    student.getGender()+":"+
                    student.getAge()+":"+
                    student.getGrade()+"\n");
            filewrite.close();
            return true;
        } 
        catch (IOException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Student> view() {
        try {
            Scanner sc=new Scanner(file);
            ArrayList<Student> studentList=new ArrayList<>();
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                String arr[]=line.split(":");
                String FirstName=arr[0];
                String LastName=arr[1];
                String Gender=arr[3];
                Integer age=Integer.valueOf(arr[4]);
                Integer grade=Integer.valueOf(arr[5]);
                student=new Student(FirstName, LastName, Gender, age, grade);
                studentList.add(student);
            }
            return studentList;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
