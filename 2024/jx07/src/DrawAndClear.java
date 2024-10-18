import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class DrawAndClear extends JPanel {
  private ArrayList<Shape> shapes = new ArrayList<>();

  public DrawAndClear() {
    // マウスクリックで円を追加
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        shapes.add(new Ellipse2D.Double(e.getX(), e.getY(), 50, 50));
        repaint(); // 再描画
      }
    });

    // 削除ボタン
    JButton clearButton = new JButton("Clear");
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        shapes.clear(); // 全ての図形をクリア
        repaint(); // 再描画
      }
    });

    // ボタンをパネルに追加
    this.setLayout(new BorderLayout());
    this.add(clearButton, BorderLayout.SOUTH);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    // shapesリストの図形を描画
    for (Shape shape : shapes) {
      g2d.draw(shape);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Draw and Clear Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.add(new DrawAndClear());
    frame.setVisible(true);
  }
}
