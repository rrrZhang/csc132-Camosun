import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsePoint extends JFrame implements ActionListener {

    private JButton goButton;
    private JPanel panel;
    JTextField output;

    public static void main(String[] args) {
        UsePoint demo = new UsePoint();
        demo.setSize(200, 250);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 150));
        panel.setBackground(Color.white);
        window.add(panel);

        goButton = new JButton("go");
        window.add(goButton);
        goButton.addActionListener(this);

        output = new JTextField(10);
        window.add(output);
        output.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        Point p1, p2;
        p1 = new Point(50, 50);
        p2 = new Point(2, 5);

        paper.drawRect(p1.getX(), p1.getY(), 10, 10);
        p1.setX(2);
        p1.setY(5);
        paper.drawRect(p1.getX(), p1.getY(), 10, 10);
        if (p1.equals(p2)) {
            output.setText("equal");
        } else {
            output.setText("not equal");
        }
    }
}

class Point {

    private int xcord, ycord;     // x and y coordinates of the point

    public Point() {
        xcord = 0;
        ycord = 0;
    }

    public Point(int x, int y) {
        xcord = x;
        ycord = y;
    }

    public void setX(int newX) {
        xcord = newX;
    }

    public void setY(int newY) {
        ycord = newY;
    }

    public int getX() {
        return xcord;
    }

    public int getY() {
        return ycord;
    }

    public boolean equals(Point p) {
        if (xcord == p.xcord && ycord == p.ycord) {
            return true;
        } else {
            return false;
        }
    }
}


