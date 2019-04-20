/*
 * RGBcolors.java
 * @author: Zhang Xiaoqing
 * Date: created on: October 06, 2016, 3:43 PM
 * Purpose: This program displays various red-green-blue color combinations,
 * arbitrary colors can be created by providing to the constructor three integers, 
 * each between 0 and 255, three integers represent red, green and blue color 
 * components of the RGB model.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RGBcolors extends JFrame implements ActionListener {

    private JButton lessRed, moreRed, lessGreen, moreGreen, lessBlue, moreBlue, randomColor;
    private JLabel redLabel, greenLabel, blueLabel;
    private JPanel panel;
    private Random random;
    int redValue = 120;
    int greenValue = 50;
    int blueValue = 70;

    /*
     * Builds the window frame
     * Receives: frame size, creatGUI
     */
    public static void main(String[] args) {
        RGBcolors demo = new RGBcolors();
        demo.setSize(900, 400);
        demo.createGUI();
        demo.setVisible(true);
    }

    /*
     * Builds the creatGUI, panel, three labels: redLabel, greenLabel, blueLabel;
     * seven buttons: moreRed, lessRed, moreGreen, lessGreen, moreBlue, lessBlue,
     * randomColor
     * Receives: the size and background of panel, three labels and seven buttons
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        redLabel = new JLabel("Red: " + redValue); // create the label of red
        window.add(redLabel);

        moreRed = new JButton("More red"); // create the button of more red
        window.add(moreRed);
        moreRed.addActionListener(this);

        lessRed = new JButton("Less red"); // create the button of less red
        window.add(lessRed);
        lessRed.addActionListener(this);

        greenLabel = new JLabel("Green: " + greenValue); // create the label of green
        window.add(greenLabel);

        moreGreen = new JButton("More green"); // create the button of more green
        window.add(moreGreen);
        moreGreen.addActionListener(this);

        lessGreen = new JButton("Less Green"); // create the button of less green
        window.add(lessGreen);
        lessGreen.addActionListener(this);

        blueLabel = new JLabel("Blue: " + blueValue); // create the label of blue
        window.add(blueLabel);

        moreBlue = new JButton("More blue"); // create the button of more blue
        window.add(moreBlue);
        moreBlue.addActionListener(this);

        lessBlue = new JButton("Less blue"); // create the button of less blue
        window.add(lessBlue);
        lessBlue.addActionListener(this);

        randomColor = new JButton("Random color"); // create the button of random color
        window.add(randomColor);
        randomColor.addActionListener(this);

        random = new Random();

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 300));
        panel.setBackground(Color.white);
        window.add(panel);

    }

    /*
     * Reacts the seven button click, calls other methods, draw three rectangles and 
     * one circle
     * Receives: red values, green values and blue values, three rectangles and 
     * one circle
     */
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        Graphics paper = panel.getGraphics();

        if (source == moreRed) { // if press moreRed button
            redValueUp(); // calls redValueUp method
        } else if (source == lessRed) { // if press lessRed button
            redValueDown(); // calls redValueDown method
        } else if (source == moreGreen) { // if press moreGreen button
            greenValueUp(); // calls greenValueUp method
        } else if (source == lessGreen) { // if press lessGreen button
            greenValueDown(); // calls greenValueDown method
        } else if (source == moreBlue) { // if press moreBlue button
            blueValueUp(); // calls blueValueUp method
        } else if (source == lessBlue) { // if press lessBlue button
            blueValueDown(); // calls blueValueDown method
        } else if (source == randomColor) { // if press randomColor button
            redValue = random.nextInt(256); // set red random value between 0 and 255
            greenValue = random.nextInt(256); // set green random value between 0 and 255
            blueValue = random.nextInt(256); // set blue random value between 0 and 255
            redLabel.setText("Red: " + redValue); // display red value on redLabel
            greenLabel.setText("Green: " + greenValue); // display green value on greenLabel
            blueLabel.setText("Blue: " + blueValue); // display blue value on blueLabel
        }

        Color mix = new Color(redValue, greenValue, blueValue);
        paper.setColor(mix); // set color of circle
        paper.fillOval(130, 130, 140, 140); // draw a circle
        Color a = new Color(redValue);
        paper.setColor(a); // set color of the first rectangle
        paper.fillRect(50, 50, 40, 30); // draw the first rectangle
        Color b = new Color(0, greenValue, 0);
        paper.setColor(b); // set color of the second rectangle
        paper.fillRect(175, 50, 40, 30); // draw the second rectangle
        Color c = new Color(0, 0, blueValue);
        paper.setColor(c); // set color of the third rectangle
        paper.fillRect(300, 50, 40, 30); // draw the third rectangle
    }

    /*
     * Reacts the moreRed button, sets the red value maximun and if over the 
     * maximun, display the erroe message
     * Receives: red values or error message
     * Retuens: red value
     */
    private void redValueUp() {
        if (redValue == 250) {
            redValue = redValue + 5;
            redLabel.setText("Red: " + redValue);
        } else if (redValue <= 240) {
            redValue = redValue + 10;
            redLabel.setText("Red: " + redValue);
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    /*
     * Reacts the lessRed button, sets the red value minimun and if lower than the 
     * minimun, display the erroe message
     * Receives: red values or error message
     * Retuens: red value
     */
    private void redValueDown() {
        if (redValue == 5) {
            redValue = redValue - 5;
            redLabel.setText("Red: " + redValue);
        } else if (redValue > 0) {
            redValue = redValue - 10;
            redLabel.setText("Red: " + redValue);
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    /*
     * Reacts the moreGreen button, sets the green value maximun and if over the 
     * maximun, display the erroe message
     * Receives: green values or error message
     * Retuens: green value
     */
    private void greenValueUp() {
        if (greenValue == 250) {
            greenValue = greenValue + 5;
            greenLabel.setText("Green: " + greenValue);
        } else if (greenValue <= 240) {
            greenValue = greenValue + 10;
            greenLabel.setText("Green: " + greenValue);
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    /*
     * Reacts the lessGreen button, sets the green value minimun and if lower than the 
     * minimun, display the erroe message
     * Receives: green values or error message
     * Retuens: green value
     */
    private void greenValueDown() {
        if (greenValue == 5) {
            greenValue = greenValue - 5;
            greenLabel.setText("Green: " + greenValue);
        } else if (greenValue > 0) {
            greenValue = greenValue - 10;
            greenLabel.setText("Green: " + greenValue);
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    /*
     * Reacts the moreBlue button, sets the blue value maximun and if over the 
     * maximun, display the erroe message
     * Receives: blue values or error message
     * Retuens: blue value
     */
    private void blueValueUp() {
        if (blueValue == 250) {
            blueValue = blueValue + 5;
            blueLabel.setText("Blue: " + blueValue);
        } else if (blueValue <= 240) {
            blueValue = blueValue + 10;
            blueLabel.setText("Blue: " + blueValue);
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    /*
     * Reacts the lessBlue button, sets the blue value minimun and if lower than the 
     * minimun, display the erroe message
     * Receives: blue values or error message
     * Retuens: blue value
     */
    private void blueValueDown() {
        if (blueValue == 5) {
            blueValue = blueValue - 5;
            blueLabel.setText("Blue: " + blueValue);
        } else if (blueValue > 0) {
            blueValue = blueValue - 10;
            blueLabel.setText("Blue: " + blueValue);
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
