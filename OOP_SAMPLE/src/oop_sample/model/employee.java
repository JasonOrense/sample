/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sample.model;

/**
 *
 * @author Jason
 */
public class employee {
    private String password, username, fName, lName, mName;
    private int emp_number;
    
    public void setEmpNumber(int emp_number){ this.emp_number = emp_number; }
    public int getEmpNumber(){ return this.emp_number; }
    
    public void setUsername(String username){ this.username = username; }
    public String getUsername(){ return this.username; }
    
    public void setPassword(String password){ this.password = password; }
    public String getPassword(){ return this.password; }
    
    public void setFname(String fName){ this.fName = fName; }
    public String getFname(){ return this.fName; }
    
    public void setLname(String lName){ this.lName = lName; }
    public String getLname(){ return this.lName; }
    
    public void setMname(String mName){ this.mName = mName; }
    public String getMname(){ return this.mName; }
}
