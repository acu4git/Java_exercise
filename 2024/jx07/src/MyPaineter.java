import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MyPaineter extends JPanel implements ActionListener, MouseListener {
  // 図形モードの定義
  enum Mode {
    LINE,
    RECT,
    OVAL,
  };

  private JPanel drawPanel, optionPanel;
  private JButton btnLine, btnRect, btnOval, btnBlack, btnRed, btnGreen, btnClear, btnQuit;
  private Color currentColor;
  private Mode mode;
  private int x1, y1, x2, y2, w, h;

  private class ShapeWithColor {
    public Shape shape;
    public Color color;

    ShapeWithColor(Shape shape, Color color) {
      this.shape = shape;
      this.color = color;
    }
  }

  private ArrayList<ShapeWithColor> components = new ArrayList<>();

  private class DrawPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;

      for (ShapeWithColor c : components) {
        g2d.setColor(c.color);
        g2d.draw(c.shape);
      }
    }
  }

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(500, 600);
    f.setTitle("MyPainter");

    MyPaineterMock mp = new MyPaineterMock();
    Container c = f.getContentPane();
    c.add(mp);
    f.setVisible(true);
  }

  MyPaineter() {
    setLayout(new FlowLayout());

    // 描画画面の初期化
    drawPanel = new DrawPanel();
    drawPanel.setPreferredSize(new Dimension(400, 400));
    drawPanel.setBackground(Color.WHITE);
    drawPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
    drawPanel.addMouseListener(this);

    // ボタンパネルの初期化
    optionPanel = new JPanel();
    optionPanel.setLayout(new FlowLayout());
    optionPanel.setPreferredSize(new Dimension(250, 400));

    btnLine = new JButton("Line");
    btnRect = new JButton("Rect");
    btnOval = new JButton("Oval");
    btnBlack = new JButton("Black");
    btnRed = new JButton("Red");
    btnGreen = new JButton("Green");
    btnClear = new JButton("Clear");
    btnQuit = new JButton("Quit");

    JButton[] btnList = { btnLine, btnRect, btnOval, btnBlack, btnRed, btnGreen, btnClear, btnQuit };
    for (JButton btn : btnList) {
      btn.addActionListener(this);
      optionPanel.add(btn);
    }

    add(drawPanel);
    add(optionPanel);

    // 描画モードや色の初期化等
    mode = Mode.LINE;
    currentColor = Color.BLACK;
    x1 = x2 = y1 = y2 = -1;
    w = h = 0;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object action = e.getSource();

    if (action == btnQuit) {
      System.out.println("Quit");
      System.exit(0);
    }

    if (action == btnClear) {
      System.out.println("--- CLEARED ---");
      components.clear();
      drawPanel.repaint();
    }

    // 図形モードの変更
    if (action == btnLine) {
      System.out.println("--- LINE MODE ---");
      mode = Mode.LINE;
    } else if (action == btnRect) {
      System.out.println("--- RECT MODE ---");
      mode = Mode.RECT;
    } else if (action == btnOval) {
      System.out.println("--- OVAL MODE ---");
      mode = Mode.OVAL;
    }

    // 色情報の変更
    if (action == btnBlack) {
      currentColor = Color.BLACK;
      System.err.printf("--- COLOR CHANGED(%s) ---\n", currentColor.toString());
    } else if (action == btnRed) {
      currentColor = Color.RED;
      System.err.printf("--- COLOR CHANGED(%s) ---\n", currentColor.toString());
    } else if (action == btnGreen) {
      currentColor = Color.GREEN;
      System.err.printf("--- COLOR CHANGED(%s) ---\n", currentColor.toString());
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
    x1 = e.getX();
    y1 = e.getY();
    System.out.printf("Pressed: (%d, %d)\n", x1, y1);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    x2 = e.getX();
    y2 = e.getY();
    w = Math.abs(x1 - x2);
    h = Math.abs(y1 - y2);
    System.out.printf("Released: (%d, %d)\n", x2, y2);

    Shape shape = null;

    switch (mode) {
      case LINE:
        shape = new Line2D.Double(x1, y1, x2, y2);
        break;
      case RECT:
        shape = new Rectangle2D.Double(Math.min(x1, x2), Math.min(y1, y2), w, h);
        break;
      case OVAL:
        shape = new Ellipse2D.Double(Math.min(x1, x2), Math.min(y1, y2), w, h);
        break;
    }

    components.add(new ShapeWithColor(shape, currentColor));
    drawPanel.repaint();
  }

}
