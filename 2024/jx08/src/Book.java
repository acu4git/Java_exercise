public class Book {
  private String title;
  private String author;
  private String publisher;
  private String isbn; // ISBN-10かISBN-13かは問わない

  public Book(String title, String author, String publisher, String isbn) {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.isbn = isbn;
  }

  public boolean validate() {
    if (this.title == "")
      return false;
    if (this.author == "")
      return false;
    if (this.publisher == "")
      return false;
    if (this.isbn == "")
      return false;

    return true;
  }

  public boolean contains(String text) {
    if (this.title.contains(text))
      return true;
    if (this.author.contains(text))
      return true;
    if (this.publisher.contains(text))
      return true;
    if (this.isbn.contains(text))
      return true;

    return false;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getISBN() {
    return isbn;
  }

  public void setISBN(String isbn) {
    this.isbn = isbn;
  }

  public String toCSV() {
    return getTitle() + "," + getAuthor() + "," + getPublisher() + "," + getISBN();
  }
}
