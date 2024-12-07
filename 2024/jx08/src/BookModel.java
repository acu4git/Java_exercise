import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BookModel {
  private String filepath = "book.txt";
  private ArrayList<Book> bookList;

  public BookModel() {
    initBookList();
  }

  private void initBookList() {
    bookList = new ArrayList<>();
    try (BufferedReader buffReader = new BufferedReader(new FileReader(this.filepath))) {
      while (true) {
        String line = buffReader.readLine();
        if (line == null)
          break;
        String[] tokens = line.split(",");
        Book book = new Book(tokens[0], tokens[1], tokens[2], tokens[3]);
        bookList.add(book);
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  public void write(Book book) {
    try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(this.filepath, true))) {
      buffWriter.write(book.toCSV());
      buffWriter.newLine();
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    bookList.add(book);
  }

  public ArrayList<Book> readAll() {
    return this.bookList;
  }
}
