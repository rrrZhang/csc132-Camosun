/*
 * Escape.java
 * @Author: Zhang Xiaoqing
 * Date: Created on: October 27, 2016, 3:33 PM
 * Purpose: This program simulates the walk of a drunkard in a 11 by 11 square street 
 * grid that is patroled by two policeman. The simulated person is trying to reach the 
 * outskirts of the town. Have the simulated person randomly pick a direction and 
 * move one block. There are two patrol policeman placed at random locations, that 
 * don't change during the drunkman walk. display the message when drunk person
 * does not escape to the outside, or still inside the two but over the 50 moves, 
 * or escape the town. and display the message for the if drunk peroson escape. 
 * Every block is 100 meters long.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Escape extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;
    private Random random;

    /*
     *Builds the window frame
     *Receives: frame size, creatGUI
     */
    public static void main(String[] args) {
        Escape frame = new Escape();
        frame.setSize(450, 470);
        frame.createGUI();
        frame.show();
    }

    /*
     * Builds the creatGUI, one start button, panel
     * Receives: one start button and the size and background of panel,
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 380));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("START"); // create the button of start
        window.add(button);
        button.addActionListener(this);

        random = new Random();
    }

    /*
     * Reacts the start button click, calls other methods, draw 11 by 11 square 
     * grid, one red oval represents the drunk person and two blue ovals represents
     * the policeman.
     * Receives: 11 by 11 square grid, one red oval and two blue ovals, display the
     * message when drunk person does not escape to the outside, or still inside the two 
     * but over the 50 moves, or escape the town. and display the message of the distance 
     * if drunk peroson escape.
     */
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        int x; // x position at left top corner of the panel   
        int y; // y position at left top corner of the panel
        int p1x, p2x, p1y, p2y; // two policemen x and y general position
        int rp1x, rp1y, rp2x, rp2y;//put two policemen x and y position in the squar grid
        int dx = 180, dy = 180; // drunk person's original x and y position
        int diameters = 20; // dismeter of oval(drunk peroson and two policemen)
        int directions; // directions of drunk person move
        int distances; // if drunk peroson escape, calculate the distence he traveled

        p1x = random.nextInt(11) + 1; // first policeman x position 
        rp1x = p1x * 30; // put first policeman x position in the squar grid
        p1y = random.nextInt(11) + 1; // first policeman y position
        rp1y = p1y * 30; // put first policeman y position in the squar grid
        do {
            p2x = random.nextInt(11) + 1;
            rp2x = p2x * 30;
            p2y = random.nextInt(11) + 1;
            rp2y = p2y * 30;
        } while (p1x == p2x && p1y == p2y);//two policeman positions are not at same place 

        paper.setColor(Color.BLUE); // two policemen oval color is blue
        paper.fillOval(rp1x, rp1y, diameters, diameters); // draw first policeman
        paper.fillOval(rp2x, rp2y, diameters, diameters); // draw second policeman

        y = 40; // y position change from 0 to 40
        for (int hlines = 1;
                hlines <= 11; hlines++) { // loop repeats 11 times
            paper.setColor(Color.black); // color of lines are black
            paper.drawLine(40, y, 340, y);
            y = y + 30; // each line distance is 30
        } // draw 11 horizontal lines

        x = 40; // x position change from 0 to 40
        for (int vlines = 1;
                vlines <= 11; vlines++) { // loop repeats 11 times
            paper.setColor(Color.black); // color of lines are black
            paper.drawLine(x, 40, x, 340);
            x = x + 30; // each line distance is 30
        } // draw 11 vertical lines

        paper.setColor(Color.red);//drunk man is a red oval when he is moving
        paper.fillOval(dx, dy, diameters, diameters);//drunk man position after he move

        for (int n = 1; n <= 50 && dx <= 300 && dx >= 60
                && dy >= 60 && dy <= 300
                && !(dx == rp1x && dy == rp1y)
                && (dx != rp2x || dy != rp2y);
                n++) {//loop repeats 50 times if dx, dy inside the grid and not meet policemen  

            directions = random.nextInt(4);//4 random positions(north, south, east, west)
            distances = calculateDistances(n); // call calculateDistances method 

            paper.setColor(Color.white);//ereasing drunk person's previous position
            paper.fillOval(dx, dy, diameters, diameters);

            paper.setColor(Color.black);//redraw the lines after drunk person left
            paper.drawLine(dx, dy + 10, dx + 20, dy + 10); // redraw horizontal lines
            paper.drawLine(dx + 10, dy, dx + 10, dy + 20); // redraw vertical lines

            if (directions == 0) { // if random number is 0
                dx = dx - 30;// drunk man x position move left
            } else if (directions == 1) {// if random number is 1
                dx = dx + 30;// drunk man x position move right
            } else if (directions == 2) {// if random number is 2
                dy = dy - 30;// drunk man y position move up
            } else if (directions == 3) {// if random number is 3
                dy = dy + 30;// drunk man y position move down
            }

            paper.setColor(Color.red);//drunk man is a red oval when he is moving
            paper.fillOval(dx, dy, diameters, diameters);//drunk man position after he move

            if (dx == rp1x && dy == rp1y
                    || dx == rp2x && dy == rp2y) {//if drunk man meet two policemen
                JOptionPane.showMessageDialog(null,
                        "You have been arrested!");// display proper message
            } else if (dx == 30 || dx == 330
                    || dy == 30 || dy == 330) { // if drunk man escape 
                JOptionPane.showMessageDialog(null, "You luckly made it!"
                        + " \n You have traveled " + distances
                        + " meters"); // display proper message
            } else if (n == 50 && dx >= 60 && dx <= 300
                    && dy <= 300 && dy >= 60) { // if drunk man didn't escape within 50 moves
                JOptionPane.showMessageDialog(null,
                        "You are out of luck!"); // display proper message
            }

            delay(); // call delay method
        }
        paper.setColor(Color.white); //ereasing everything
        paper.fillRect(0, 0, 400, 380);
        y = 40; // redraw 11 horizontal lines  
        for (int hlines = 1;
                hlines <= 11; hlines++) {
            paper.setColor(Color.black);
            paper.drawLine(40, y, 340, y);
            y = y + 30;
        }

        x = 40; // redraw 11 vertical lines
        for (int vlines = 1;
                vlines <= 11; vlines++) {
            paper.setColor(Color.black);
            paper.drawLine(x, 40, x, 340);
            x = x + 30;
        }
    }

    /*method delay stops the program for 200 miliseconds
     *Receives: no parameters
     *Returns: void
     */
    private void delay() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
    }

    /*
     *Calculates when drunk person escape, how lone he traveled
     *Receives: how many times(n) loop repeat
     *Returns: calculated diatance
     */
    private int calculateDistances(int n) {
        int distances = n * 100;
        return distances;
    }
}
