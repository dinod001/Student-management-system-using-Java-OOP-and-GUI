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
public class StudentDB implements Istudent {

    Student student;
    File file = new File("D:\\StudentDetails.txt");

    @Override
    public boolean insert(Student student) {
        try {
            FileWriter filewrite = new FileWriter(file, true);
            filewrite.write(student.getFirstName() + ":"
                    + student.getLastName() + ":"
                    + student.getGender() + ":"
                    + student.getAge() + ":"
                    + student.getGrade() + "\n");
            filewrite.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Student> view() {
        try {
            Scanner scan = new Scanner(file);
            ArrayList<Student> studentlist=new ArrayList<>();
            while(scan.hasNextLine()){
                String line=scan.nextLine();
                String arr[]=line.split(":");
                String firstname=arr[0];
                String lastname=arr[1];
                String Gender=arr[2];
                int age=Integer.valueOf(arr[3]);
                int grade=Integer.valueOf(arr[4]);
                student=new Student(firstname, lastname, Gender, age, grade);
                studentlist.add(student);
            }
            return studentlist;
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
