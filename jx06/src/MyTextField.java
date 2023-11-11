import java.awt.*;
import javax.swing.*;

class MyTextField extends JFrame {
    Container c;
    JTextField tf;

    MyTextField() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setTitle("MyTextField");

        c = getContentPane();
        c.setLayout(new FlowLayout());
        tf = new JTextField("Hello Java World!", 16);
        c.add(tf);
    }

    public static void main(String[] args) {
        MyTextField o = new MyTextField();
        o.setVisible(true);
    }
}
