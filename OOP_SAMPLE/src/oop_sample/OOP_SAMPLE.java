/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sample;

import oop_sample.controller.loginController;
import oop_sample.model.loginModel;
import oop_sample.view.loginView;

/**
 *
 * @author Jason
 */
public class OOP_SAMPLE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loginView lView = new loginView();
        loginModel lModel = new loginModel();
        loginController lControlller = new loginController(lView, lModel);
        lView.setVisible(true);
    }
    
}
