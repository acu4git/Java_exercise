import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyDraw extends JPanel implements MouseListener {
    private int x1, x2, y1, y2;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setTitle("MyDraw");
        Container c = f.getContentPane();

        MyDraw md = new MyDraw();
        c.add(md);
        f.setVisible(true);
    }

    public MyDraw() {
        addMouseListener(this);
        x1 = x2 = y1 = y2 = 0;
    }

    public void paintComponent(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }

    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
