/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author DSYS
 */
public class Student {
    private String FirstName;
    private String LastName;
    private String Gender;
    private int age;
    private int grade;

    public Student(String FirstName, String LastName, String Gender, int age, int grade) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.age = age;
        this.grade = grade;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getGender() {
        return Gender;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }
    
    
}
