
import GUI.OuterFrame;
import domein.DomeinController;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nathan
 */
public class Init {
    public static void main(String args[]){
        OuterFrame frame = new OuterFrame(new DomeinController());
        frame.toStartPanel();
    }
}
