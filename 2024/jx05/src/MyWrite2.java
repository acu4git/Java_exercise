import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyWrite2 {
  public static void main(String args[]) {
    String writeData;

    try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter("hello.txt"));) {
      writeData = "Hello!";
      buffWriter.write(writeData);
      buffWriter.newLine();
      writeData = "Javaの勉強は";
      buffWriter.write(writeData);
      buffWriter.newLine();
      writeData = "進んでいますか？";
      buffWriter.write(writeData);
      buffWriter.newLine();
    } catch (IOException e) {
      System.out.println("Write Error");
    }
  }
}