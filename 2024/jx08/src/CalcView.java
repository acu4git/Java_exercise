import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalcView extends JFrame implements ActionListener {
  private CalcCtrl ctrl;
  private Container c;
  private JLabel leq, lres;
  private JTextField tf1, tfop, tf2;
  private JButton b1, b2;
  private JPanel p1, p2;

  CalcView() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 300);
    setTitle("CalcApp");

    c = getContentPane();
    c.setLayout(new FlowLayout(FlowLayout.CENTER));

    // ctrl = new CalcCtrl();
    tf1 = new JTextField(4);
    tfop = new JTextField(1);
    tf2 = new JTextField(4);
    leq = new JLabel("=");
    lres = new JLabel();
    b1 = new JButton("Calc");
    b2 = new JButton("Clear");
    p1 = new JPanel();
    p2 = new JPanel();

    p1.add(tf1);
    p1.add(tfop);
    p1.add(tf2);
    p1.add(leq);
    p1.add(lres);
    c.add(p1);

    p2.add(b1);
    p2.add(b2);
    c.add(p2);

    b1.addActionListener(this);
    b2.addActionListener(this);
  }

  public void setCalcCtrl(CalcCtrl ctrl) {
    this.ctrl = ctrl;
  }

  public void actionPerformed(ActionEvent e) {
    Object actionSrc = e.getSource();
    if (actionSrc == b1) {
      String res = ctrl.calc(tf1, tfop, tf2);
      lres.setText(res);
    } else if (actionSrc == b2) {
      tf1.setText("");
      tfop.setText("");
      tf2.setText("");
      lres.setText("");
    }
  }

  public static void main(String[] args) {
    CalcView cv = new CalcView();
    CalcCtrl cc = new CalcCtrl();
    CalcModel cm = new CalcModel();
    cc.setCalcModel(cm);
    cv.setCalcCtrl(cc);

    cv.setVisible(true);
  }
}
