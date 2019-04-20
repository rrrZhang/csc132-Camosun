/*
 * Archery.java
 * @author C0413901
 * Created on September 15, 2016, 3:54 PM
 * Purpose: This program draws an archery target on the screen
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Archery extends JFrame implements ActionListener{
    
    private JButton button;
    private JPanel panel;
    
    public static void main (String[] args) {
        Archery frame = new Archery();
        frame.setSize(400, 350);
        frame.creatGUI();
        frame.setVisible(true);
    }
    private void creatGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window. setLayout(new FlowLayout());
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,250));
        panel.setBackground(Color.YELLOW);
        window.add(panel);
        
        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event){
        Graphics paper = panel.getGraphics();
        paper.setColor(Color.BLACK);
        paper.fillOval(50, 25, 200, 200);  // draw the first circle
        paper.setColor(Color.BLUE);
        paper.fillOval(75, 50, 150, 150);  // draw the second circle
        paper.setColor(Color.RED);
        paper.fillOval(100, 75, 100,100);  // draw the third circle
        paper.setColor(Color.yellow);
        paper.fillOval(125, 100, 50, 50);  // draw the fourth circle
        paper.setColor(Color.BLACK);
        paper.drawLine(125, 125, 175, 125);  // draw the horizontal line
        paper.drawLine(150, 100, 150, 150);  // draw the vertical line
             
   
    }    
    
    
    
    
}
