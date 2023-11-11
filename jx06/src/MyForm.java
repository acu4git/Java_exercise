import java.awt.*;
import javax.swing.*;

public class MyForm extends JFrame {
    JLabel ll1;
    JTextField tf1;
    JCheckBox cb1;
    JButton bn1;

    MyForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 100);
        setTitle("MyForm");

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ll1 = new JLabel("Name");
        tf1 = new JTextField("", 12);
        cb1 = new JCheckBox("request");
        bn1 = new JButton("OK");

        c.add(ll1);
        c.add(tf1);
        c.add(cb1);
        c.add(bn1);
    }

    public static void main(String[] args) {
        MyForm mf = new MyForm();
        mf.setVisible(true);
    }
}
