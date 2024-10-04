import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyRead2 {
  public static void main(String args[]) {
    String readData;
    int nline = 1;

    try (BufferedReader buffReader = new BufferedReader(new FileReader("hello.txt"));) {
      readData = buffReader.readLine();
      while (readData != null) {
        System.out.println(nline + "行目：" + readData);
        nline++;
        readData = buffReader.readLine();
      }
    } catch (IOException e) {
      System.out.println("Read Error");
    }
  }
}