class TryCtrl {
  private TryModel mdl;

  TryCtrl() {
    mdl = new TryModel();
  }

  public String convertMessage(String str) {
    String res;

    res = mdl.convertMessage(str);
    return res;
  }
}