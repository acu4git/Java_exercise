import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookModel {
  private ArrayList<Book> bookList;
  private BufferedReader buffReader;

  public BookModel() {
    try {
      buffReader = new BufferedReader(new FileReader("book.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      buffReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void register(Book book) {

  }
}
