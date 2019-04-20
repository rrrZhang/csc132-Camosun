/*
 * DailyWeather.java
 * @author: Zhang Xiaoqing
 * Date: created on: November 06, 2016, 3:43 PM
 * Purpose: This program writes a java class called DailyWeather which defines a 
 * daily weather object. The Daily Weather object has the following attributes: 
 * a weather description, current temperature, daily minimum and daily maximum 
 * temperatures. And Write an application which creates three objects of type 
 * DailyWeather and stores them in the array. Set tempture and change tempture.
 * and display the description, current, minimum, maximum and average temperatures.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Weather extends JFrame implements ActionListener {

    private JButton button;
    private JTextArea output;
    private DailyWeather[] day = new DailyWeather[3];//creates the day array, length is 3

    /*
     *Builds the window frame
     *Receives: frame size, creatGUI
     */
    public static void main(String[] args) {
        Weather demo = new Weather();
        demo.setSize(750, 450);
        demo.createGUI();
        demo.setVisible(true);
    }

    /*
     * Builds the creatGUI, textarea, one start button
     * Receives: one start button, the size of the textarea
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        output = new JTextArea(20, 65);
        window.add(output);

        button = new JButton("Start");//// create the start button
        window.add(button);
        button.addActionListener(this);
    }

    /*
     * Reacts the button click and calls other methods, Store all three objects 
     * in the array of type DailyWeather.
     * Receives: a weather description, current temperature, daily minimum and 
     * daily maximum temperatures. And display the description, current, minimum,
     * maximum and average temperatures.
     */
    public void actionPerformed(ActionEvent event) {

        day[0] = new DailyWeather("Cloudy", 5);//Create the first DailyWeather object. 
        day[0].setTem(14);//Change temperature to 14.
        day[1] = new DailyWeather("Rainy and Windy", 3);//Create second DailyWeather object.
        day[1].setTem(10);//Change temperature to 10.
        day[2] = new DailyWeather("Sunny", 18);//Create the third DailyWeather object.
        day[2].setTem(11);//Change temperature to 11.

        for (int i = 0; i < day.length; i++) {// if i =0, i < day.length = 2, loop repeats
            output.append("Min: " + day[i].getMinimum() + "\t"//call method getMinimum
                    + "Max: " + day[i].getMaximum() + "\t"//call method getMaximum
                    + "Current: " + day[i].getTem() + "\t"//call method getTem
                    + "Average: " + day[i].getAverage() + "\t"//call method getAverage
                    + day[i].getDescription() + "\n");//call method getDescription
        }//display the description, current, minimum, maximum and average temperatures
    }
}

class DailyWeather {

    private int curTempture;// declare current tem. variable
    private int maxTem; // declare the maximum tem.
    private int minTem; // declare the min tem.
    private String description; // declare String description

    public DailyWeather(String newDes, int curTem) { // constructor
        curTempture = curTem;// initialize curTempture to the current tem.
        maxTem = curTem;// initialize maxTem to the current tem.
        minTem = curTem;//initialize mintem to the current tem.
        description = newDes;// initialize description to the newDes
    }

    /*
     *set the String newDes to the description
     *Receives: the new description.
     */
    public void setDescription(String newDes) {
        description = newDes;
    }

    /*
     *returns dailyweather description
     *Receives: description
     *Returns: description
     */
    public String getDescription() {
        return description;
    }

    /*
     *set the new tem. to the current tem., compare and get the max tem. and min tem.
     *Receives: the new tem.
     */
    public void setTem(int newTem) {
        curTempture = newTem;

        if (curTempture >= maxTem) { // if current tem. greater than max tem.
            maxTem = curTempture;// max tem. equal to current tem.
        }
        if (curTempture <= minTem) { // if current tem. less than min tem.
            minTem = curTempture;// min tem. equal to current tem.
        }
    }

    /*
     *returns current temperature
     *Receives: current temperature
     *Returns:current temperature
     */
    public int getTem() {
        return curTempture;
    }

    /*
     *returns maximum temperature
     *Receives: maximum temperature
     *Returns:maximum temperature
     */
    public int getMaximum() {
        return maxTem;
    }

    /*
     *returns minimum temperature
     *Receives: minimum temperature
     *Returns:minimum temperature
     */
    public int getMinimum() {
        return minTem;
    }

    /*
     *Calculates the daily average temperature
     *Receives: minimum tem and maximum tem
     *Returns:daily average temperature
     */
    public double getAverage() {
        double aveTem;
        aveTem = (minTem + maxTem) / 2.0;
        return aveTem;
    }
}
