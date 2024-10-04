import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyForm3 extends JFrame implements ActionListener {
    Container c;
    JTextField tf;
    JButton printBtn;
    JButton clearBtn;

    MyForm3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setTitle("MyForm3");

        c = getContentPane();
        c.setLayout(new FlowLayout());
        tf = new JTextField("", 16);
        printBtn = new JButton("Print");
        clearBtn = new JButton("Clear");
        c.add(tf);
        c.add(printBtn);
        c.add(clearBtn);

        printBtn.addActionListener(this);
        clearBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == printBtn) {
            String str = tf.getText();
            System.out.println(str);
        } else if (e.getSource() == clearBtn) {
            tf.setText("");
        }
    }

    public static void main(String[] args) {
        MyForm3 mf3 = new MyForm3();
        mf3.setVisible(true);
    }
}
