import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyForm2 extends JFrame implements ActionListener { // ActionListenerを実装
  private Container c;
  private JLabel l1;
  private JButton b1, b2;
  private String message;

  public MyForm2() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(180, 100);
    setTitle("MyForm2");
    c = getContentPane();

    l1 = new JLabel(" Merry X'mas! ");
    b1 = new JButton("Change");
    b2 = new JButton("Exit");
    message = "Happy New Year!";

    c.setLayout(new FlowLayout());
    c.add(l1);
    c.add(b1);
    c.add(b2);

    b1.addActionListener(this);
    b2.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) { // ActionListenerの場合，イベントが発生するとこのメソッドが呼ばれる
    if (e.getSource() == b1) { // イベント発生時に行う処理を書く
      String str = l1.getText();
      l1.setText(message);
      message = str;
    } else if (e.getSource() == b2) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    MyForm2 mf = new MyForm2();
    mf.setVisible(true);
  }
}