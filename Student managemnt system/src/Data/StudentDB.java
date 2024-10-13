/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DSYS
 */
public class StudentDB implements Istudent{

    @Override
    public boolean insert(Student student) {
        File file=new File("D:\\StudentDetails.txt");
        try {
            FileWriter filewrite=new FileWriter(file,true);
            filewrite.write(student.getFirstName()+":"+
                    student.getLastName()+":"+
                    student.getGender()+":"+
                    student.getAge()+":"+
                    student.getGender()+"\n");
            filewrite.close();
            return true;
        } 
        catch (IOException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void view() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
