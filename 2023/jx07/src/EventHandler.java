import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EventHandler extends JPanel implements ActionListener, MouseListener {
    ViewPanel panel;
    int x1, x2, y1, y2, w, h;
    Color color;

    enum MODE {
        LINE,
        RECT,
        OVAL,
        CLEAR,
    };

    MODE mode;

    EventHandler(ViewPanel vp) {
        this.revalidate();
        panel = vp;
        color = Color.BLACK;
        mode = MODE.LINE;

        x1 = x2 = y1 = y2 = 0;
        w = h = 1;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);

        switch (mode) {
            case LINE:
                g.drawLine(x1, y1, x2, y2);
                break;
            case RECT:
                g.drawRect(x1, y1, w, h);
                break;
            case OVAL:
                g.drawOval(x1, y1, w, h);
                break;
            case CLEAR:
                super.paintComponent(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object actionSrc = ae.getSource();

        if (actionSrc == panel.lineButton) {
            mode = MODE.LINE;
        } else if (actionSrc == panel.rectButton) {
            mode = MODE.RECT;
        } else if (actionSrc == panel.ovalButton) {
            mode = MODE.OVAL;
        } else if (actionSrc == panel.blackButton) {
            color = Color.BLACK;
        } else if (actionSrc == panel.redButton) {
            color = Color.RED;
        } else if (actionSrc == panel.greenButton) {
            color = Color.GREEN;
        } else if (actionSrc == panel.clearButton) {
            MODE tmp = mode;
            mode = MODE.CLEAR;
            panel.repaint();
            mode = tmp;
        } else if (actionSrc == panel.quitButton) {
            System.exit(0);
        }
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        x1 = me.getX();
        y1 = me.getY();

        // debug
        System.out.println("--- " + mode + " mode (" + color + ") ---");
        System.out.println("x1: " + x1 + ", y1: " + y1);
    }

    public void mouseReleased(MouseEvent me) {
        if (mode == MODE.LINE) {
            x2 = me.getX();
            y2 = me.getY();
            panel.repaint();

            // debug
            System.out.println("x2: " + x2 + ", y2: " + y2);
        } else {
            w = Math.abs(x1 - x2);
            h = Math.abs(y1 - y2);
            panel.repaint();

            // debug
            System.out.println("w: " + w + ", h: " + h);
        }
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }
}
