/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author DSYS
 */
public interface Istudent {

    public abstract boolean insert(Student student);

    public abstract ArrayList<Student> view();

    public abstract void search();

}
