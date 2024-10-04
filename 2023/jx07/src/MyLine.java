import java.awt.*;
import javax.swing.*;

public class MyLine extends JPanel {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setTitle("MyLine");
        Container c = f.getContentPane();

        MyLine ml = new MyLine();
        c.add(ml);
        f.setVisible(true);
    }

    public MyLine() {
        setBackground(Color.white);
        setMinimumSize(new Dimension(250, 250));
        setPreferredSize(new Dimension(400, 400));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(50, 50, 300, 300);
        g.setColor(Color.red);
        g.drawLine(50, 300, 300, 150);
        g.setColor(Color.blue);
        g.drawRect(260, 50, 100, 50);
        g.setColor(Color.green);
        g.drawOval(100, 100, 200, 200);
        g.setColor(Color.pink);
        g.drawOval(50, 50, 200, 100);
    }
}
