import java.awt.*;
import javax.swing.*;

public class MyFlowLayout extends JFrame {
    Container c;
    JButton b1;
    JButton b2;
    JButton b3;

    MyFlowLayout() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setTitle("MyFlowLayout");

        c = getContentPane();
        c.setLayout(new FlowLayout());
        b1 = new JButton("Button1");
        c.add(b1);
        b2 = new JButton("Button2");
        c.add(b2);
        b3 = new JButton("Button3");
        c.add(b3);
    }

    public static void main(String[] args) {
        MyFlowLayout o = new MyFlowLayout();
        o.setVisible(true);
    }
}
