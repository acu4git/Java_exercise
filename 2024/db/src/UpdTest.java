import java.sql.*;

public class UpdTest {
  private static final String sqlSelectAll = "SELECT * FROM Student";
  private static final String sqlInsertStudent = "INSERT INTO Student(sno, sname, address, age) VALUES('00000001', 'Piga', 'Before', 300)";
  private static final String sqlUpdateAddress = "UPDATE Student SET address = 'After' WHERE sname = 'Piga'";

  public static void main(String[] args) {
    try {
      // ドライバクラスをロード
      Class.forName("org.sqlite.JDBC");

      // データベースに接続
      Connection con = DriverManager.getConnection("jdbc:sqlite:/home/shaun/SQL/stock3.sqlite3");

      // ステートメントオブジェクトを生成
      Statement st = con.createStatement();

      // 初期状態の確認
      ResultSet rs = st.executeQuery(sqlSelectAll);
      System.out.println("================== (0)初期状態 ==================");
      while (rs.next()) {
        String sno = rs.getString("sno");
        String sname = rs.getString("sname");
        String address = rs.getString("address");
        int age = rs.getInt("age");
        System.out.println("sno:" + sno + " sname:" + sname + " address:" + address +
            " age:" + age);
      }

      // (1) 一人分のデータの挿入
      st.executeUpdate(sqlInsertStudent);
      System.out.println("================== (1)挿入 ==================");

      // (2) (1)で挿入したデータが本当に挿入されているかの確認（＝検索）
      System.out.println("================== (2)確認 ==================");
      rs = st.executeQuery(sqlSelectAll);
      while (rs.next()) {
        String sno = rs.getString("sno");
        String sname = rs.getString("sname");
        String address = rs.getString("address");
        int age = rs.getInt("age");
        System.out.println("sno:" + sno + " sname:" + sname + " address:" + address +
            " age:" + age);
      }

      // (3) (1)で挿入したデータの住所(address)の修正（適当な修正でOK）
      st.executeUpdate(sqlUpdateAddress);
      System.out.println("================== (3)修正 ==================");

      // (4) (3)で修正したデータが本当に修正されているかの確認（＝検索）
      System.out.println("================== (4)確認 ==================");
      rs = st.executeQuery(sqlSelectAll);
      while (rs.next()) {
        String sno = rs.getString("sno");
        String sname = rs.getString("sname");
        String address = rs.getString("address");
        int age = rs.getInt("age");
        System.out.println("sno:" + sno + " sname:" + sname + " address:" + address +
            " age:" + age);
      }

      // データベースから切断
      st.close();
      con.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
