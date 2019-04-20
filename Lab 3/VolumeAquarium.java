/*
 * VolumeAquarium.java
 * @author: Zhang Xiaoqing
 * Date: created on: September 29, 2016, 3:43 PM
 * Purpose: This program calculates and displays volume of an aquarium 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VolumeAquarium extends JFrame
        implements ActionListener {

    private JButton button;
    private JPanel panel;

    /*
     *Builds the window frame
     *Receives: frame size, creatGUI
     */
    public static void main(String[] args) {
        VolumeAquarium frame = new VolumeAquarium();
        frame.setSize(400, 350);
        frame.creatGUI();
        frame.setVisible(true);
    }

    /*
     *Builds the creatGUI, panel and button
     *Receives: the size and background of panel, the button
     */
    private void creatGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 250));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    /*
     *Reacts the button click and calls other methods
     *Receives: length, width and depth input from user, the volume of aquarium 
     *of returned, message dialog of aquarium volume
     */
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        double volume; //stores calculated volume value 
        int length; //enter length of Aquarium by user
        int width; //enter width of Aquarium by user
        int depth; //enter depth of Aquarium by user
        String lengthString;
        String widthString;
        String depthString;

        lengthString = JOptionPane.showInputDialog("Enter length: ");
        length = Integer.parseInt(lengthString); //convert input to an integer
        widthString = JOptionPane.showInputDialog("Enter width: ");
        width = Integer.parseInt(widthString); //convert input to an integer
        depthString = JOptionPane.showInputDialog("Enter depth: ");
        depth = Integer.parseInt(depthString); //convert input to an integer

        volume = calculateVolume(length, width, depth); //call calculateVolume method
        drawAquarium(paper, 0, 0, depth, length); //call drawAquarium method
        JOptionPane.showMessageDialog(null, "Aquarium Volume: " + volume);
    }

    /*
     *Calculates aquarium's volume
     *Receives: length, width, depth of the aquarium
     *Returns: calculated volume
     */
    private double calculateVolume(int length, int width, int depth) {
        double volume;
        volume = length * width * depth;
        return volume;
    }

    /*
     *Draws the crossection of the aquarium which shows the length and depth
     *Receives: Graphics object, x and y coordinates for the top-left 
     *corner,depth and length of the aquarium
     */
    private void drawAquarium(Graphics drawingArea, int x, int y,
            int depth, int length) {
        drawingArea.drawRect(x, y, depth, length);
    }
}
