import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TryView extends JFrame implements ActionListener {
  private TryCtrl ctrl;
  private Container c;
  private JLabel l1;
  private JButton b1, b2;

  public TryView() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(180, 100);
    setTitle("TryView");

    ctrl = new TryCtrl();

    c = getContentPane();

    l1 = new JLabel("  Merry X'mas!  ");
    b1 = new JButton("Change");
    b2 = new JButton("Exit");

    c.setLayout(new FlowLayout());
    c.add(l1);
    c.add(b1);
    c.add(b2);

    b1.addActionListener(this);
    b2.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
      String str = l1.getText();
      l1.setText(ctrl.convertMessage(str));
    } else if (e.getSource() == b2) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    TryView tv = new TryView();

    tv.setVisible(true);
  }
}
