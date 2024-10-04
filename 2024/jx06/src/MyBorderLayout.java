import java.awt.*;
import javax.swing.*;

class MyBorderLayout extends JFrame {
  Container c;
  JButton b1;
  JButton b2;
  JButton b3;
  JButton b4;
  JButton b5;

  MyBorderLayout() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(200, 100);
    setTitle("MyBorderLayout");

    c = getContentPane();
    c.setLayout(new BorderLayout());
    b1 = new JButton("B1");
    c.add(b1, BorderLayout.NORTH);
    b2 = new JButton("B2");
    c.add(b2, BorderLayout.CENTER);
    b3 = new JButton("B3");
    c.add(b3, BorderLayout.SOUTH);
    b4 = new JButton("B4");
    c.add(b4, BorderLayout.WEST);
    b5 = new JButton("B5");
    c.add(b5, BorderLayout.EAST);
  }

  public static void main(String[] args) {
    MyBorderLayout o = new MyBorderLayout();
    o.setVisible(true);
  }
}