/*
 * SnackDispensingMachine.java
 * @author: Zhang Xiaoqing
 * Date: created on: September 22, 2016, 3:50 PM
 * Purpose: This program calculates the change
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SnackDispensingMachine extends JFrame
        implements ActionListener {

    private JButton button; //when clicked change calculation is performed

    public static void main(String[] args) {
        SnackDispensingMachine frame = new SnackDispensingMachine();
        frame.setSize(400, 300);
        frame.creatGUI();
        frame.setVisible(true);
    }

    private void creatGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int itemCost; //enter item cost by user
        int amountInserted; //enter amount inserted by user
        int change; //change dispensed to user
        int quarters; //number of quarters given
        int dimes; //number of dimes given
        int nickels; //number of nickels given
        int pennies; //number of pennies given
        String itemCostString;
        String amountInsertedString;

        itemCostString = JOptionPane.showInputDialog("Enter item cost"
                + "(<= 100 cents), in cents");
        itemCost = Integer.parseInt(itemCostString); //convert input to an integer
        amountInsertedString = JOptionPane.showInputDialog("Enter amout insered"
                + "(<= 100 cents),in cents");
        amountInserted = Integer.parseInt(amountInsertedString); //convert input to an integer

        change = amountInserted - itemCost; //calculates change
        quarters = change / 25; //calculates quarters
        dimes = change % 25 / 10; //calculates dimes
        nickels = change % 25 % 10 / 5; //calculates nickels
        pennies = change % 25 % 10 % 5; //calculates pennies
        JOptionPane.showMessageDialog(null, " change : " + change
                + " \n quarters : " + quarters
                + " \n dimes : " + dimes
                + " \n nickels : " + nickels
                + " \n pennies : " + pennies); //display change and the number of coins

    }
}
