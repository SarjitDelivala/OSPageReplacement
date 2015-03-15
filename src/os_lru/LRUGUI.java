/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_lru;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author SARJIT
 */
public class LRUGUI {

    JFrame frame;
    JButton add;
    JLabel frames,pages,pageFault;
    LRU algo;
    
    public LRUGUI(LRU a) {
    
        algo = a;
        frame = new JFrame("Least Recently Used Page Replacement Algo");
        frame.setSize(550,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new GridLayout(4,1));
        
        frames = new JLabel("Frames : ");
        
        
        pages = new JLabel("Pages : ");
        
        add = new JButton("Add Page");
        
        pageFault = new JLabel("Page Faults : ");
        
        frame.add(pages);
        frame.add(frames);
        frame.add(pageFault);
        frame.add(add);
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String input ;
                while(true)
                {
                    int page;
                    input = JOptionPane.showInputDialog("Enter Page Number :");
                    if(input == null){
                        break;
                    }
                    if(input.matches("([0-9])+"))
                    {
                        page = Integer.parseInt(input);
                        algo.addPage(page);
                        frames.setText(frames.getText() + (frames.getText().equalsIgnoreCase("Frames : ")? "" :" , ") + algo.printFrames());
                        pages.setText(pages.getText() + (pages.getText().equalsIgnoreCase("Pages : ")? "" :" , ") + input);
                        pageFault.setText("Page Faults : " + algo.getPageFaults());
                        break;
                    }
                    JOptionPane.showMessageDialog(null, "Frame Number should be an Integer.");
                }
            }
        });
        
        frame.setVisible(true);
    }
    
}
