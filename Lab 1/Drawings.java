/*
 * Drawings.java
 * @author  Downarowicz
 * Created on May 11, 2005, 10:21 AM
 * Purpose: This program demonstrates use of graphics methods
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Drawings extends JFrame implements ActionListener{

  private JButton button;
  private JPanel panel;

  public static void main(String[] args) {
    Drawings frame = new Drawings();
    frame.setSize(400,350);
    frame.createGUI();
    frame.setVisible(true);
  }

  private void createGUI(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = getContentPane();
    window.setLayout(new FlowLayout());

    panel = new JPanel();
    panel.setPreferredSize(new Dimension(300,200));
    panel.setBackground(Color.white);
    window.add(panel);

    button = new JButton("Click here");
    window.add(button);
    button.addActionListener(this);

  }

  public void actionPerformed(ActionEvent e){
    Graphics paper = panel.getGraphics();
    paper.drawLine(0,0,100,100);
    paper.drawRect(5,5, 50, 70);
    paper.setColor(Color.red);
    paper.drawString("Welcome to Java", 70, 30);
  }


}
