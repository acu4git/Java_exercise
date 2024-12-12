import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BookView extends JFrame implements ActionListener, ChangeListener {
  private BookCtrl ctrl;
  private Container c;
  private JPanel panelRegister, panelList;
  private JTabbedPane tabbedPane;

  private String[] columnsNames = { "書名", "著者名", "出版社", "ISBN" };
  // 一覧用
  private JTable table;
  private DefaultTableModel tableModel1;
  private JTextField tfSearch;
  private JButton btnSearch;
  private JPanel panelSearch;
  // 登録用
  private JLabel lTitle, lAuthor, lPublisher, lISBN, lStatus;
  private JTextField tfTitle, tfAuthor, tfPublisher, tfISBN;
  private JButton btnRegister, btnReset;

  public static void main(String[] args) {
    BookView bv = new BookView();
    bv.setVisible(true);
  }

  public BookView() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 600);
    setTitle("BookApp");

    c = getContentPane();

    ctrl = new BookCtrl();

    // 一覧画面
    initPanelList();
    // 登録画面の初期化
    initPanelRegister();

    // タブ遷移
    tabbedPane = new JTabbedPane();
    tabbedPane.addTab("一覧", panelList);
    tabbedPane.addTab("登録", panelRegister);
    tabbedPane.addChangeListener(this);

    c.add(tabbedPane, BorderLayout.CENTER);
  }

  private void initPanelList() {
    panelList = new JPanel();
    panelList.setLayout(new BoxLayout(panelList, BoxLayout.Y_AXIS));
    // 検索部
    panelSearch = new JPanel();
    tfSearch = new JTextField(16);
    btnSearch = new JButton("検索");
    btnSearch.addActionListener(this);
    panelSearch.add(tfSearch);
    panelSearch.add(btnSearch);
    panelList.add(panelSearch);
    // 表示部
    tableModel1 = new DefaultTableModel(columnsNames, 0);
    var bookList = ctrl.list();
    for (Book book : bookList) {
      Object[] row = { book.getTitle(), book.getAuthor(), book.getPublisher(), book.getISBN() };
      tableModel1.addRow(row);
    }
    table = new JTable(tableModel1);
    JScrollPane scrollPane = new JScrollPane(table);
    panelList.add(scrollPane);
  }

  private void initPanelRegister() {
    panelRegister = new JPanel();
    lTitle = new JLabel(columnsNames[0]);
    tfTitle = new JTextField(16);
    lAuthor = new JLabel(columnsNames[1]);
    tfAuthor = new JTextField(16);
    lPublisher = new JLabel(columnsNames[2]);
    tfPublisher = new JTextField(16);
    lISBN = new JLabel(columnsNames[3]);
    tfISBN = new JTextField(16);
    btnRegister = new JButton("登録");
    btnReset = new JButton("リセット");
    lStatus = new JLabel("");

    GroupLayout layout = new GroupLayout(panelRegister);
    panelRegister.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
    // 水平方向
    layout.setHorizontalGroup(
        layout.createSequentialGroup()
            .addGroup(
                layout.createParallelGroup()
                    .addComponent(lTitle)
                    .addComponent(lAuthor)
                    .addComponent(lPublisher)
                    .addComponent(lISBN)
                    .addComponent(btnRegister)
                    .addComponent(lStatus))
            .addGroup(
                layout.createParallelGroup()
                    .addComponent(tfTitle)
                    .addComponent(tfAuthor)
                    .addComponent(tfPublisher)
                    .addComponent(tfISBN)
                    .addComponent(btnReset)));
    // 垂直方向
    layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addGroup(
                layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lTitle)
                    .addComponent(tfTitle))
            .addGroup(
                layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lAuthor)
                    .addComponent(tfAuthor))
            .addGroup(
                layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lPublisher)
                    .addComponent(tfPublisher))
            .addGroup(
                layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lISBN)
                    .addComponent(tfISBN))
            .addGroup(
                layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnReset))
            .addGroup(
                layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lStatus)));
    btnRegister.addActionListener(this);
    btnReset.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    Object action = e.getSource();
    if (action == btnRegister) {
      Book book = new Book(tfTitle.getText(), tfAuthor.getText(), tfPublisher.getText(), tfISBN.getText());
      var ok = ctrl.register(book);
      lStatus.setText(ok ? "登録しました" : "不適切な入力です");
      if (ok) {
        tfTitle.setText("");
        tfAuthor.setText("");
        tfPublisher.setText("");
        tfISBN.setText("");
      }
    } else if (action == btnReset) {
      tfTitle.setText("");
      tfAuthor.setText("");
      tfPublisher.setText("");
      tfISBN.setText("");
    } else if (action == btnSearch) {
      tableModel1.setRowCount(0);
      var bookList = ctrl.search(tfSearch.getText());
      for (Book book : bookList) {
        Object[] row = { book.getTitle(), book.getAuthor(), book.getPublisher(), book.getISBN() };
        tableModel1.addRow(row);
      }
    }
  }

  public void stateChanged(ChangeEvent e) {
    int id = tabbedPane.getSelectedIndex();
    if (id == 0) {
      tfSearch.setText("");
      tableModel1.setRowCount(0);
      var bookList = ctrl.list();
      for (Book book : bookList) {
        Object[] row = { book.getTitle(), book.getAuthor(), book.getPublisher(), book.getISBN() };
        tableModel1.addRow(row);
      }
    }
  }
}
