import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MousePos extends JPanel implements MouseListener {
  private int x, y;
  private int w;

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(400, 400);
    f.setTitle("MousePos");
    Container c = f.getContentPane();

    MousePos ml = new MousePos();
    c.add(ml);
    f.setVisible(true);
  }

  public MousePos() {
    addMouseListener(this);
    x = 10;
    y = 10;
    w = 4;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawOval(x, y, w, w);
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseClicked(MouseEvent e) {
    x = e.getX() - w / 2;
    y = e.getY() - w / 2;
    System.out.println("x: " + x + " y: " + y);
    repaint();
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

}