/**
 *Ball.java
 *This program displays ball bouncing within a rectangle
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bouncer1 extends JFrame implements ActionListener {

  private JButton button;
  private JPanel panel;

  public static void main(String[] args) {
    Bouncer1 frame = new Bouncer1();
    frame.setSize(200,150);
    frame.createGUI();
    frame.setVisible(true);
  }

  private void createGUI() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = getContentPane();
    window.setLayout(new FlowLayout() );

    panel = new JPanel();
    panel.setPreferredSize(new Dimension(100, 100));
    panel.setBackground(Color.white);
    window.add(panel);

    button = new JButton("go");
    window.add(button);
    button.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
    int x = 7, y = 2;   //ball's original x and y position
    int xChange = 7;    //number of pixels the ball moves horizontally
    int yChange = 2;    //number of pixels the ball moves vertically
    int diameter=10;    //ball's diameter

    int rectLeftX = 0, rectRightX = 100;  //rectangles parameters
    int rectTopY = 0, rectBottomY = 100;

    Graphics g = panel.getGraphics();

    g.setColor(Color.white);
    g.fillRect(0,0,100,100);


    //ball bounces 200 times
    for (int n = 1; n<= 200; n++) {
      g.setColor(Color.white);
      g.fillOval (x, y, diameter, diameter);//ereasing ball's previous position

      if (x + xChange <= rectLeftX){       //test if the right wall was reached
        xChange = -xChange;
      }else if(x+xChange+diameter >= rectRightX){//test if the left wall was reached
        xChange = -xChange;
      }

      if (y+yChange <= rectTopY){          //test if the top wall was reached
        yChange = -yChange;
      }else if(y+yChange+diameter >= rectBottomY){//test if the bottom wall was reached
        yChange = -yChange;
      }
      x = x + xChange;          //calculate ball's new x position
      y = y + yChange;          //calculate ball's new y position

      g.setColor(Color.red);
      g.fillOval (x, y, diameter, diameter);  //draw ball in the new position
      delay();

    }
  }
  /*method delay stops the program for 50 miliseconds
   *Receives: no parameters
   *Returns: void
  */
  private void delay(){
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {}
  }
}

