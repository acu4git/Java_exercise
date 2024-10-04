import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Persist {
  public static void main(String[] args) {
    String buffNumber = null;
    String buffName = null;

    try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter("student.txt"));
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));) {
      while (true) {
        // 学生番号
        System.out.print("No: ");
        buffNumber = buffReader.readLine();
        if (buffNumber.equals("q")) {
          System.out.println("入力を終わります");
          break;
        }
        // 氏名
        System.out.print("Name: ");
        buffName = buffReader.readLine();

        buffWriter.write(buffNumber + " " + buffName);
        buffWriter.newLine();
      }
    } catch (IOException e) {
      System.err.println("Keyboard input error.");
    }
  }
}
