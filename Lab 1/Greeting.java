/*
 * Greeting.java
 * @author  Downarowicz
 * Created on May 11, 2005, 10:21 AM
 * Purpose: This program uses a JTextfield to display a line of text
 */

import javax.swing.*;
import java.awt.*;

public class Greeting extends JFrame {

  private JTextField textField;

  public static void main(String[] args) {
    Greeting frame = new Greeting();
    frame.setSize(300,100);
    frame.createGUI();
    frame.show();
  }

  private void createGUI(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = getContentPane();
    window.setLayout(new FlowLayout());
    textField = new JTextField("Hello");
    window.add(textField);
  }

}

