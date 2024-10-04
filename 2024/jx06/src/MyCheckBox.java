import java.awt.*;
import javax.swing.*;

class MyCheckBox extends JFrame {
  Container c;
  JCheckBox cb;

  MyCheckBox() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(200, 100);
    setTitle("MyCheckBox");

    c = getContentPane();
    c.setLayout(new FlowLayout());
    cb = new JCheckBox("ON");
    c.add(cb);
  }

  public static void main(String[] args) {
    MyCheckBox o = new MyCheckBox();
    o.setVisible(true);
  }
}