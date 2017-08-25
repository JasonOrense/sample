/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oop_sample.model.employee;

/**
 *
 * @author Jason
 */
public class query {
    private Connection connection;
    public query(){
        this.connection = database.connect_db();
    }
    
    public ArrayList<employee> login(String username, String password) {
        CallableStatement cs = null;
        ResultSet rs = null;
        
        ArrayList<employee> ArrayEmployees = new ArrayList<>();
        
        try{
            cs = connection.prepareCall("{call login(?, ?)}");
            cs.setString(1, username);
            cs.setString(2, password);
            cs.execute();
            rs = cs.getResultSet();
            
            while(rs.next()){
                employee emp = new employee();
                emp.setEmpNumber(rs.getInt("emp_number"));
                emp.setFname(rs.getString("first_name"));
                emp.setLname(rs.getString("last_name"));
                emp.setMname(rs.getString("middle_name"));
                ArrayEmployees.add(emp);
            }
            
        } catch(SQLException x){
            JOptionPane.showMessageDialog(null, x, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            try{
                if (cs != null) cs.close();
                if (rs != null) rs.close();
                connection.close();
            } catch(SQLException x){
                Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, x);
            }
        }
        
        return ArrayEmployees;
    }
    
    public void callProcedure(employee emp){
        CallableStatement cStatement = null;
        ResultSet rSet = null;
        
        try{
            cStatement = connection.prepareCall("");
            cStatement.setString(1, emp.getUsername());
            
            
        } catch(SQLException sql){
            
        }
    }
}
