/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sample.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import oop_sample.model.homeModel;
import oop_sample.model.loginModel;
import oop_sample.view.homeJFrameView;
import oop_sample.view.loginView;

/**
 *
 * @author Jason
 */
public class loginController {
    private loginModel lModel;
    private loginView lView;
    
    public loginController(loginView lView, loginModel lModel){
        this.lView = lView;
        this.lModel = lModel;
        
        lView.addLoginActionListener(new LoginListener());
        lView.addUsernameKeyListener(new textFieldKeyListener());
        lView.addPasswordKeyListener(new textFieldKeyListener());
    }
    
    private class textFieldKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                logInProccess();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
        
    }
    
    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            logInProccess();
        }
        
    }
    
    private void logInProccess(){
        
        if (!lView.getUsername().isEmpty() && !lView.getPassword().isEmpty()){
            
            lModel.checkUsernamePassword(lView.getUsername(), lView.getPassword());
                
            if (lModel.getCount() == 1){
                
                lView.showSuccesMsg("Username and Password accepted!");
                System.out.println("Fname : " + lModel.getFirst().getFname());
                System.out.println("Lname : " + lModel.getFirst().getLname());
                System.out.println("Mname : " + lModel.getFirst().getMname());
                
                homeJFrameView hView = new homeJFrameView();
                homeModel hModel = new homeModel();
                homeJFrameController homeController = new homeJFrameController(hView, hModel, lModel);
                hView.setVisible(true);
                    
                lView.dispose();
                    
            } else {
                
                lView.showErrorMsg("Username and Password incorrect!");
                
            }
        } else {
            
            lView.showErrorMsg("Username or Password is Empty");
            
        }    
        
    }
    
}
