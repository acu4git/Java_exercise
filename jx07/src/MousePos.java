import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MousePos extends JPanel implements MouseListener {
    private int x, y;
    private int x2, y2;

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
        x = y = x2 = y2 = 0;
    }

    public void paintComponent(Graphics g) {
        // super.paintComponent(g);
        g.drawLine(x, y, x2, y2);
    }

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
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
