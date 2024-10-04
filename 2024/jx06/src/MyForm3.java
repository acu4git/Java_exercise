import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyForm3 extends JFrame implements ActionListener {
  private Container c;
  private JTextField tf;
  private JButton btnPrint, btnClear;

  MyForm3() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 400);
    setTitle("MyForm3");
    c = getContentPane();

    c.setLayout(new FlowLayout());
    tf = new JTextField("", 12);
    btnPrint = new JButton("Print");
    btnClear = new JButton("Clear");
    btnPrint.addActionListener(this);
    btnClear.addActionListener(this);

    c.add(tf);
    c.add(btnPrint);
    c.add(btnClear);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnPrint) {
      System.out.println(tf.getText());
    } else if (e.getSource() == btnClear) {
      tf.setText("");
    }
  }

  public static void main(String[] args) {
    MyForm3 mf = new MyForm3();
    mf.setVisible(true);
  }
}
