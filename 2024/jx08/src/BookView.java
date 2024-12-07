import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class BookView extends JFrame implements ActionListener {
  private BookCtrl ctrl;
  private Container c;
  private JPanel panelRegister, panelList, panelSearch;
  private JTabbedPane tabbedPane;
  // 一覧用
  // 登録用
  private JLabel lTitle, lAuthor, lPublisher, lISBN;
  private JTextField tfTitle, tfAuthor, tfPublisher, tfISBN;
  private JButton btnRegister;
  // 検索用
  private JTextField tfSearch;
  private JButton btnSearch;
  private JTable tableSearch;

  private JTable table;
  private String[] columns = { "書名", "著者名", "出版社", "ISBN" };

  public static void main(String[] args) {
    BookView bv = new BookView();
    bv.setVisible(true);
  }

  public BookView() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 600);
    setTitle("BookApp");

    c = getContentPane();

    ctrl = new BookCtrl();

    // 一覧画面
    panelList = new JPanel();
    // 検索画面
    panelSearch = new JPanel();
    // 登録画面の初期化
    initPanelRegister();

    // テーブルの初期化
    table = new JTable();

    // タブ遷移
    tabbedPane = new JTabbedPane();
    tabbedPane.addTab("一覧", panelList);
    tabbedPane.addTab("検索", panelSearch);
    tabbedPane.addTab("登録", panelRegister);

    c.add(tabbedPane, BorderLayout.CENTER);
  }

  private void initPanelRegister() {
    panelRegister = new JPanel();
    panelRegister.setLayout(new FlowLayout(FlowLayout.LEADING));
    JLabel[] labels = { lTitle, lAuthor, lPublisher, lISBN };
    JTextField[] textFields = { tfTitle, tfAuthor, tfPublisher, tfISBN };
    for (int i = 0; i < 4; i++) {
      JPanel p = new JPanel();
      p.setLayout(new FlowLayout(FlowLayout.CENTER));
      labels[i] = new JLabel(columns[i]);
      textFields[i] = new JTextField(16);
      p.add(labels[i]);
      p.add(textFields[i]);
      panelRegister.add(p);
    }
    btnRegister = new JButton("登録");
    panelRegister.add(Box.createRigidArea(new Dimension(0, 0)));
    panelRegister.add(btnRegister);
  }

  public void actionPerformed(ActionEvent e) {
    Object action = e.getSource();
    if (action == btnRegister) {
      Book book = new Book(tfTitle.getText(), tfAuthor.getText(), tfPublisher.getText(), tfISBN.getText());
      ctrl.register(book);
    } else if (action == btnSearch) {

    }
  }
}
