import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NestedMethod extends JFrame
  implements ActionListener {

  private JButton button;
  private JPanel panel;
  private int total = 35;

  public static void main(String[] args) {
    NestedMethod frame = new NestedMethod();
    frame.setSize(350, 300);
    frame.createGUI();
    frame.setVisible(true);
  }

  private void createGUI() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = getContentPane();
    window.setLayout(new FlowLayout() );

    panel = new JPanel();
    panel.setPreferredSize(new Dimension(300, 200));
    panel.setBackground(Color.white);
    window.add(panel);

    button = new JButton("Press me");
    window.add(button);
    button.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
    int  d;
    int  z;
    d = modify(5);
    z = modify(modify(5));

    JOptionPane.showMessageDialog(null,"d = " + d + "   z = " + z + "   total = " + total);
  }

  private int modify(int c){
    total = total + 1;
    return (c + 10);
  }
}


