import java.sql.*;
import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Selall extends JFrame {
  private Container c;
  private JPanel panel;
  private JTable table;
  private DefaultTableModel tableModel;
  private JScrollPane sp;
  private String[] columnNames = { "Number", "Name", "Address", "Age" };

  private class Student {
    private String no;
    private String name;
    private String address;
    private int age;

    Student(String no, String name, String address, int age) {
      this.no = no;
      this.name = name;
      this.address = address;
      this.age = age;
    }

    public String getNo() {
      return no;
    }

    public String getName() {
      return name;
    }

    public String getAddress() {
      return address;
    }

    public int getAge() {
      return age;
    };
  }

  public static void main(String[] args) {
    Selall s = new Selall();
    s.setVisible(true);
  }

  public Selall() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 600);
    setTitle("Selall");

    c = getContentPane();

    panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER));

    tableModel = new DefaultTableModel(columnNames, 0);

    var studentList = getAllStudent();
    for (Student s : studentList) {
      Object[] row = { s.getNo(), s.getName(), s.getAddress(), s.getAge() };
      tableModel.addRow(row);
    }
    table = new JTable(tableModel);
    sp = new JScrollPane(table);
    panel.add(sp);

    c.add(panel);
  }

  private ArrayList<Student> getAllStudent() {
    ArrayList<Student> result = new ArrayList<>();
    try {
      // ドライバクラスをロード
      Class.forName("org.sqlite.JDBC");

      // データベースに接続
      Connection con = DriverManager.getConnection("jdbc:sqlite:/home/shaun/SQL/stock3.sqlite3");

      // ステートメントオブジェクトを生成
      Statement st = con.createStatement();

      // 全てのタプルを検索するSQL文を作成
      String sql = "SELECT * FROM Student";

      // 問い合わせを実行して結果集合を取得
      ResultSet rs = st.executeQuery(sql);

      // 検索されたタプルを繰り返し処理する
      while (rs.next()) {
        // snoを取得
        String sno = rs.getString("sno");
        // snameを取得
        String sname = rs.getString("sname");
        // addressを取得
        String address = rs.getString("address");
        // ageを取得
        int age = rs.getInt("age");

        result.add(new Student(sno, sname, address, age));
      }
      // データベースから切断
      st.close();
      con.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return result;
  }
}