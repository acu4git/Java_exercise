import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MyKeyboardInput2 {
  public static void main(String args[]) {
    String buff = null;

    try (BufferedReader buffKeyboard = new BufferedReader(new InputStreamReader(System.in));) {
      // ○○○○ は 標準入力
      System.out.println("文字列を入力してください（タブ入力で終了します）．");
      do {
        System.out.print(">");
        // キーボードから１行読んでbuffに入れる
        buff = buffKeyboard.readLine();
        System.out.println(buff);
      } while (!buff.equals("\t")); // buffの中身がタブ（"\t"）でない間繰り返す
    } catch (IOException e) {
      System.out.println("Ketboard Input Error");
    }
  }
}