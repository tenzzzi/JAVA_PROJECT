/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaproject;

import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class smarttracker {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
            IFrontPage frame = new IFrontPage();  
            frame.setVisible(true);  
        });  
    }
}