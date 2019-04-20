/*
 * TmrDate.java
 * @Author: Zhang Xiaoqing
 * Date: Created on: October 13, 2016, 3:33 PM
 * Purpose: This program calculates the date following a given date. User enters 
 * the day, month and year. The program accounts the leap years; and detects wrong 
 * date inputs (ex. month = 13, day = 32); and displays an error message.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TmrDate extends JFrame implements ActionListener {

    private JTextField dayTextField, monthTextField, yearTextField;
    private JLabel dayLabel, monthLabel, yearLabel;
    private JButton button;

    /*
     *Builds the window frame
     *Receives: frame size, creatGUI
     */
    public static void main(String[] args) {
        TmrDate frame = new TmrDate();
        frame.setSize(300, 250);
        frame.creatGUI();
        frame.setVisible(true);
    }

    /*
     * Builds the creatGUI, three labels: dayLabel, monthLabel, yearLabel;
     * three textfield: dayTextField, monthTextField, yearTextField; and one button.
     * Receives: three labels and three textfield.
     */
    private void creatGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        dayLabel = new JLabel("Enter the day for today's date:");
        window.add(dayLabel);

        dayTextField = new JTextField(7);
        window.add(dayTextField);

        monthLabel = new JLabel("Enter the month for today'a date: ");
        window.add(monthLabel);

        monthTextField = new JTextField(7);
        window.add(monthTextField);

        yearLabel = new JLabel("Enter the year for today's date: ");
        window.add(yearLabel);

        yearTextField = new JTextField(7);
        window.add(yearTextField);

        button = new JButton("calculate");
        window.add(button);
        button.addActionListener(this);
    }

    /*
     * Reacts the button click and calls other methods
     * Receives: day, month and year input from user, the maxday of ruturned,
     * display the message of the date following a given date and display message of the 
     * invalid input.
     */
    public void actionPerformed(ActionEvent event) {
        int day; //enter the day of today by user
        int month; //enter the month of today by user
        int year; //enter the year of today bu user
        int maxDay; //use maxday to determine maximum number of days in a given month
        String dayString;
        String monthString;
        String yearString;

        dayString = dayTextField.getText();
        day = Integer.parseInt(dayString); //convert input to an integer
        monthString = monthTextField.getText();
        month = Integer.parseInt(monthString); //convert input to an integer
        yearString = yearTextField.getText();
        year = Integer.parseInt(yearString); //convert input to an integer

        maxDay = calculateMaxDay(month, year); //call calculateMaxDay method

        if (day < maxDay && day > 0) {//if today's day number less than the maxDay and > 0
            day = day + 1; // tomorrow's day number is today's day number plus 1
            JOptionPane.showMessageDialog(null, "(day/month/year)"
                    + "\n Tomorrow's date is " + day + "/" + month + "/"
                    + year);//display the date of nextday
        } else if (day == maxDay) {//if today's day number is equal to the maxDay
            day = 1;// tomorrow's day number is equal to 1
            if (month < 12 && month > 0) {//if today's month number is < 12 and > 0
                month = month + 1;// tomorrow's month number is today's month number plus 1
                JOptionPane.showMessageDialog(null, "(day/month/year)"
                        + "\n Tomorrow's date is " + day + "/" + month + "/"
                        + year);//display the date of nextday
            } else if (month == 12) {//if today's month number is equal to 12 
                month = 1;// tomorrow's month number is equal to 1
                if (year > 0) {// if year is greater than 0
                    year = year + 1;// tomorrow's year number is today's year number plus 1
                    JOptionPane.showMessageDialog(null, "(day/month/year)"
                            + "\n Tomorrow's date is " + day + "/" + month + "/" + year);
                } else {//if year is invaild number
                    JOptionPane.showMessageDialog(null, "Invalid input");//display error message
                }
            } else {//if month is invaild number
                JOptionPane.showMessageDialog(null, "Invalid input");//display error message
            }
        } else {// if day is invaild number
            JOptionPane.showMessageDialog(null, "Invalid input");//display error message
        }
    }

    /*
     *Calculates the maximum number of days in a given month
     *Receives: today's month number and year number
     *Returns: the maximum number of days in a given month
     */
    private int calculateMaxDay(int month, int year) {
        int maxDay = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxDay = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                maxDay = 30;
                break;

            case 2:
                if (year == 0 || year % 100 != 0 && year % 4 == 0) {
                    maxDay = 29;
                } else {
                    maxDay = 28;
                }
                break;
        }
        return maxDay;
    }

}


