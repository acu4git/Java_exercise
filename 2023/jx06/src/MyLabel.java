import java.awt.*;
import javax.swing.*;

public class MyLabel extends JFrame {
    Container c;
    JLabel label;

    MyLabel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setTitle("MyLabel");

        c = getContentPane();
        c.setLayout(new FlowLayout());
        label = new JLabel("Hello World!");
        c.add(label);
        label = new JLabel("Unko!");
        c.add(label);
    }

    public static void main(String[] args) {
        MyLabel o = new MyLabel();
        o.setVisible(true);
    }
}