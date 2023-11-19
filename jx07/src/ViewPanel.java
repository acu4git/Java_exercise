import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class ViewPanel extends JPanel implements ActionListener, MouseListener {
    // Buttons
    JButton lineButton, rectButton, ovalButton;
    JButton blackButton, redButton, greenButton;
    JButton clearButton, quitButton;

    int x1, x2, y1, y2, w, h;
    Color color;

    // Editor mode type
    enum MODE {
        LINE,
        RECT,
        OVAL,
        CLEAR,
    };

    MODE mode;

    // Constructor
    ViewPanel() {
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        // Set title border
        LineBorder inborder = new LineBorder(Color.BLACK, 2);
        TitledBorder border = new TitledBorder(inborder, "Canvas", TitledBorder.LEFT, TitledBorder.TOP);
        centerPanel.setBorder(border);
        border = new TitledBorder(inborder, "Select", TitledBorder.LEFT, TitledBorder.TOP);
        bottomPanel.setBorder(border);

        // Init paint editor
        color = Color.BLACK;
        mode = MODE.LINE;
        x1 = x2 = y1 = y2 = 0;
        w = h = 1;

        // Add button
        bottomPanel.setLayout(new GridLayout(3, 3));
        lineButton = new JButton("Line");
        bottomPanel.add(lineButton);
        rectButton = new JButton("Rect");
        bottomPanel.add(rectButton);
        ovalButton = new JButton("Oval");
        bottomPanel.add(ovalButton);
        blackButton = new JButton("Black");
        blackButton.setBackground(Color.LIGHT_GRAY);
        bottomPanel.add(blackButton);
        redButton = new JButton("Red");
        redButton.setForeground(Color.RED);
        redButton.setBackground(Color.PINK);
        bottomPanel.add(redButton);
        greenButton = new JButton("Green");
        greenButton.setForeground(Color.GREEN);
        greenButton.setBackground(new Color(225, 255, 212));
        bottomPanel.add(greenButton);
        clearButton = new JButton("Clear");
        clearButton.setBackground(Color.WHITE);
        bottomPanel.add(clearButton);
        quitButton = new JButton("Quit");
        quitButton.setForeground(Color.WHITE);
        quitButton.setBackground(Color.RED);
        bottomPanel.add(quitButton);

        // Add panel
        setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Send event to object eh
        centerPanel.addMouseListener(this);
        lineButton.addActionListener(this);
        rectButton.addActionListener(this);
        ovalButton.addActionListener(this);
        blackButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        clearButton.addActionListener(this);
        quitButton.addActionListener(this);
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

        if (actionSrc == lineButton) {
            mode = MODE.LINE;
        } else if (actionSrc == rectButton) {
            mode = MODE.RECT;
        } else if (actionSrc == ovalButton) {
            mode = MODE.OVAL;
        } else if (actionSrc == blackButton) {
            color = Color.BLACK;
        } else if (actionSrc == redButton) {
            color = Color.RED;
        } else if (actionSrc == greenButton) {
            color = Color.GREEN;
        } else if (actionSrc == clearButton) {
            MODE tmp = mode;
            mode = MODE.CLEAR;
            repaint();
            mode = tmp;
        } else if (actionSrc == quitButton) {
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
            repaint();

            // debug
            System.out.println("x2: " + x2 + ", y2: " + y2);
        } else {
            w = Math.abs(x1 - x2);
            h = Math.abs(y1 - y2);
            repaint();

            // debug
            System.out.println("w: " + w + ", h: " + h);
        }
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }
}
