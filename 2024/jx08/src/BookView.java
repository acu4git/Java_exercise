import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class BookView extends JFrame implements ActionListener {
  private BookCtrl ctrl;
  private Container c;
  private JPanel panelRegister, panelDisplay, panelSearch;
  private JTextField tfBookName, tfAuthor, tfPublisher, tfISBN;
  private JButton btnRegister, btnDisplay, btnSearch;

  private JTable table;
  private String[] columns = { "書名", "著者名", "出版社", "ISBN" };
  private ArrayList<Book> bookList;

  public BookView() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 600);
    setTitle("BookApp");

    c = getContentPane();
    c.setLayout(new FlowLayout(FlowLayout.CENTER));

    ctrl = new BookCtrl();

    // 一覧画面
    panelDisplay = new JPanel();

    // 登録画面
    panelRegister = new JPanel();

    // 検索画面
    panelSearch = new JPanel();

    // 画面遷移ボタン
    btnDisplay = new JButton("書籍一覧");
    btnRegister = new JButton("書籍登録");
    btnSearch = new JButton("書籍検索");

    // イベントリスナの追加
    JButton[] btnList = { btnRegister, btnDisplay, btnSearch };
    for (JButton btn : btnList) {
      btn.addActionListener(this);
    }

    // テーブルの初期化
    bookList = new ArrayList<>();
    table = new JTable();
  }

  public void actionPerformed(ActionEvent e) {
    Object action = e.getSource();
    if (action == btnRegister) {
      Book book = new Book(tfBookName.getText(), tfAuthor.getText(), tfPublisher.getText(), tfISBN.getText());
      ctrl.register(book);
    } else if (action == btnSearch) {

    }
  }

  public static void main(String[] args) {
    BookView bv = new BookView();

    bv.setVisible(true);
  }
}
