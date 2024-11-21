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
                    + student.getAge() + ":"
                    + student.getGender() + ":"
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
            ArrayList<Student> studentlist = new ArrayList<>();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String arr[] = line.split(":");
                String firstname = arr[0];
                String lastname = arr[1];
                int age = Integer.valueOf(arr[2]);
                String Gender = arr[3];
                int grade = Integer.valueOf(arr[4]);
                student = new Student(firstname, lastname, Gender, age, grade);
                studentlist.add(student);
            }
            return studentlist;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Student> search(int grade) {
        ArrayList<Student> studentlist = view();
        ArrayList<Student> categoryLsit = new ArrayList<>();
        for (int i = 0; i < studentlist.size(); i++) {
            Student student = studentlist.get(i);
            if (student.getGrade() == grade) {
                String firstname = student.getFirstName();
                String lastname = student.getLastName();
                String Gender = student.getGender();
                int age = student.getAge();
                int graden = student.getGrade();
                student = new Student(firstname, lastname, Gender, age, graden);
                categoryLsit.add(student);
            }
        }
        return categoryLsit;
    }

    @Override
    public boolean delete(String firstname) {
        ArrayList<Student> studentList=view();
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getFirstName().equals(firstname)) {
                studentList.remove(i);
                break;
            }
        }
        
        try {
            FileWriter filewrite = new FileWriter(file);
            for(Student student:studentList){
                filewrite.write(student.getFirstName() + ":"
                    + student.getLastName() + ":"
                    + student.getAge() + ":"
                    + student.getGender() + ":"
                    + student.getGrade() + "\n");
            }
            filewrite.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }

    @Override
    public boolean update(Student students) {
        ArrayList<Student> studentList=view();
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getFirstName().equals(students.getFirstName())) {
                studentList.set(i,students);
                break;
            }
        }
        try {
            FileWriter filewrite = new FileWriter(file);
            for(Student student:studentList){
                filewrite.write(student.getFirstName() + ":"
                    + student.getLastName() + ":"
                    + student.getAge() + ":"
                    + student.getGender() + ":"
                    + student.getGrade() + "\n");
            }
            filewrite.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
         
        
    }

    
}
