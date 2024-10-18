import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TryEvent extends JFrame implements ActionListener { // ActionListenerを実装
  private Container c;
  private JTextField t1;
  private JButton b1, b2, b3, bE;
  private TryEvent2 al1, al2, al3;

  public TryEvent() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(240, 100);
    // f.setSize(180, 100);
    setTitle("TryEvent");
    c = getContentPane();

    t1 = new JTextField();
    b1 = new JButton("<朝>");
    b2 = new JButton("<昼>");
    b3 = new JButton("<夜>");
    bE = new JButton("<終了>");

    c.setLayout(new BorderLayout());
    c.add(t1, BorderLayout.NORTH);
    c.add(b1, BorderLayout.WEST);
    c.add(b2, BorderLayout.CENTER);
    c.add(b3, BorderLayout.EAST);
    c.add(bE, BorderLayout.SOUTH);

    b1.addActionListener(this); // イベントソースにイベントリスナを登録
    b2.addActionListener(this);
    b3.addActionListener(this);
    bE.addActionListener(this);

    // ここから別のイベントリスナ
    al1 = new TryEvent2("you");
    al2 = new TryEvent2("are");
    al3 = new TryEvent2("happy");
    b1.addActionListener(al1);
    b2.addActionListener(al2);
    b3.addActionListener(al3);

  }

  public void actionPerformed(ActionEvent e) { // ActionListenerの場合，イベントが発生するとこのメソッドが呼ばれる
    if (e.getSource() == b1) { // イベント発生時に行う処理
      t1.setText("Good morning!");
    } else if (e.getSource() == b2) {
      t1.setText("Good afternoon!");
    } else if (e.getSource() == b3) {
      t1.setText("Good evening!");
    } else if (e.getSource() == bE) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    TryEvent mf = new TryEvent();
    mf.setVisible(true);
  }
}