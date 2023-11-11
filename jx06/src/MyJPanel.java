import java.awt.*;
import javax.swing.*;

class MyJPanel extends JPanel {
    JButton b1;
    JButton b2;

    MyJPanel() {
        setLayout(new FlowLayout());
        b1 = new JButton("Button1");
        add(b1);
        b2 = new JButton("Button2");
        add(b2);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200, 100);
        f.setTitle("MyJPanel");
        Container c = f.getContentPane();
        c.setLayout(new FlowLayout());
        MyJPanel panel = new MyJPanel();
        c.add(panel);
        f.setVisible(true);
    }

}
