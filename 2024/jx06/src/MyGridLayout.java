import java.awt.*;
import javax.swing.*;

class MyGridLayout extends JFrame {
  Container c;
  JButton b1;
  JButton b2;
  JButton b3;
  JButton b4;
  JButton b5;

  MyGridLayout() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 100);
    setTitle("MyGridLayout");

    c = getContentPane();
    c.setLayout(new GridLayout(2, 3));
    b1 = new JButton("Button1");
    c.add(b1);
    b2 = new JButton("Button2");
    c.add(b2);
    b3 = new JButton("Button3");
    c.add(b3);
    b4 = new JButton("Button4");
    c.add(b4);
    b5 = new JButton("Button5");
    c.add(b5);
  }

  public static void main(String[] args) {
    MyGridLayout o = new MyGridLayout();
    o.setVisible(true);
  }
}