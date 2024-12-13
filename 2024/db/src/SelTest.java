
////// SelTestJDBC.java ///////
import java.sql.*;

public class SelTest {
  public static void main(String[] args) {
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
        // 標準出力に表示
        System.out.println("sno:" + sno + " sname:" + sname + " address:" + address + " age:" + age);
      }
      // データベースから切断
      st.close();
      con.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}