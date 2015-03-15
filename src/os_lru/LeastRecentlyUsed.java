/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_lru;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author SARJIT
 */

public class LeastRecentlyUsed {
    public static void main(String main[])
    {
        String input;
        int frames;
        while(true)
        {
            input = JOptionPane.showInputDialog("Enter number of Frames:");
            if(input == null)
            {
                System.exit(1);
            }
            if(input.matches("([0-9])+"))
            {
                frames = Integer.parseInt(input);
                break;
            }
            JOptionPane.showMessageDialog(null, "Frame Number should be an Integer.");
        }
        
        LRUGUI gui = new LRUGUI(new LRU(frames));
    }
}
