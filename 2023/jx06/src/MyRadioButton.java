import java.awt.*;
import javax.swing.*;

class MyRadioButton extends JFrame {
    Container c;
    JRadioButton rb1;
    JRadioButton rb2;
    ButtonGroup gr;

    MyRadioButton() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setTitle("MyRadioButton");

        c = getContentPane();
        c.setLayout(new FlowLayout());
        rb1 = new JRadioButton("ON", true);
        rb2 = new JRadioButton("OFF");
        c.add(rb1);
        c.add(rb2);
        gr = new ButtonGroup();
        gr.add(rb1);
        gr.add(rb2);
    }

    public static void main(String[] args) {
        MyRadioButton o = new MyRadioButton();
        o.setVisible(true);
    }
}
