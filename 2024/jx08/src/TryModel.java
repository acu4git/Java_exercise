class TryModel {
  private String message;

  TryModel() {
    message = "Happy New Year!";
  }

  public void setMessage(String str) {
    message = str;
  }

  public String getMessage() {
    return message;
  }

  public String convertMessage(String str) {
    String res;

    res = getMessage();
    setMessage(str);
    return res;
  }
}