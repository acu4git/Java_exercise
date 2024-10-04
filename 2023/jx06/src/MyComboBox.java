import java.awt.*;
import javax.swing.*;

class MyComboBox extends JFrame {
    Container c;
    JComboBox<String> cb;

    MyComboBox() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setTitle("MyComboBox");

        c = getContentPane();
        c.setLayout(new FlowLayout());
        cb = new JComboBox<>();
        cb.addItem("item1");
        cb.addItem("item2");
        cb.addItem("item3");
        c.add(cb);
    }

    public static void main(String[] args) {
        MyComboBox o = new MyComboBox();
        o.setVisible(true);
    }
}
