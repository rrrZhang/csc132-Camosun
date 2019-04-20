
/**
 * Author: Jadwiga Downarowicz Date: 15 January 2006 Purpose: This program
 * converts cents to dollars
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DollarsDialogs extends JFrame
        implements ActionListener {

    private JButton button;  //when cliked conversion to dollars is performed

    public static void main(String[] args) {
        DollarsDialogs frame = new DollarsDialogs();
        frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int totalCents;
        int dollars;
        int centsRemaining;
        String totalCentsString;

        totalCentsString = JOptionPane.showInputDialog("Enter your amount, in cents");
        totalCents = Integer.parseInt(totalCentsString);  //convert input to an integer

        dollars = totalCents / 100;         //calculates dollars
        centsRemaining = totalCents % 100;  //calculates cents remaining
        JOptionPane.showMessageDialog(null, totalCentsString + " cents breaks down into:\n"
                + dollars + " dollars\n"
                + centsRemaining + " cents.");
    }
}
