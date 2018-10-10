/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whist;

import java.awt.EventQueue;


/**
 *
 * @author Haig
 */
public class Whist {
   
    public static void main(String[] args) {
        
        GUIClass window = new GUIClass();
        
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    window.frame.setVisible(true);
                    window.mouse();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });
    }
    
}
