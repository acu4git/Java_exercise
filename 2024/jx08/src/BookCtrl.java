import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookCtrl {
  private BookModel model;

  public BookCtrl() {
    this.model = new BookModel();
  }

  public ArrayList<Book> list() {
    return model.readAll();
  }

  public boolean register(Book book) {
    if (!book.validate())
      return false;
    if (isDuplicate(book))
      return false;
    model.write(book);
    return true;
  }

  private boolean isDuplicate(Book book) {
    var bookList = list();
    for (Book b : bookList) {
      if (b.getISBN().equals(book.getISBN()))
        return true;
    }

    return false;
  }

  public List<Book> search(String text) {
    if (text.isEmpty())
      return list();
    else
      return model.readAll().stream()
          .filter(b -> b.contains(text))
          .collect(Collectors.toList());
  }
}
