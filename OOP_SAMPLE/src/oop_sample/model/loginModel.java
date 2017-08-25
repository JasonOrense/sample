/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sample.model;

import engine.database.query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason
 */
public class loginModel {
    
    private ArrayList<employee> emp;
    
    public void checkUsernamePassword(String username, String password){
        this.emp = new query().login(username, password);
    }
    
    public int getCount(){
        return this.emp.size();
    }
    
    public employee getFirst(){
        return emp.get(0);
    }
}
