import java.awt.*;
import javax.swing.*;

class MyButton extends JFrame {
    Container c;
    JButton b;

    MyButton() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setTitle("MyButton");

        c = getContentPane();
        c.setLayout(new FlowLayout());
        b = new JButton("OK");
        c.add(b);
    }

    public static void main(String[] args) {
        MyButton o = new MyButton();
        o.setVisible(true);
    }
}