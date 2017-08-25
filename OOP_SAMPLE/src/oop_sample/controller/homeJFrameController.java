/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sample.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import oop_sample.model.homeModel;
import oop_sample.model.loginModel;
import oop_sample.view.homeJFrameView;
import oop_sample.view.loginView;

/**
 *
 * @author Jason
 */
public class homeJFrameController {
    private homeJFrameView hView;
    private homeModel hModel;
    private loginModel lModel;
    
    public homeJFrameController(homeJFrameView hView, homeModel hModel, loginModel lModel){
        this.hView = hView;
        this.hModel = hModel;
        this.lModel = lModel;
        
        showUserInfo();
        
        this.hView.addLogoutActionListener(new addaddLogoutActionListener());
    }
    
    private class addaddLogoutActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            hView.setShowMsg("Are you sure?", "Logout");
            if (hView.getLogoutResponse() == JOptionPane.YES_OPTION){
                loginView lView = new loginView();
                loginModel lModel = new loginModel();
                loginController lController = new loginController(lView, lModel);
                lView.setVisible(true);
                hView.dispose();
            }
            
        }
        
    }
    
    private void showUserInfo(){
        hView.setEmployeeName(lModel.getFirst().getEmpNumber() + " " + lModel.getFirst().getLname() 
                + ", " + lModel.getFirst().getFname() 
                + " " + lModel.getFirst().getMname());
    }
    
}
