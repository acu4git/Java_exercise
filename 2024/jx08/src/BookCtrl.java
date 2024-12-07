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
    model.write(book);
    return true;
  }

  public List<Book> search(String text) {
    return model.readAll().stream()
        .filter(b -> b.contains(text))
        .collect(Collectors.toList());
  }
}
