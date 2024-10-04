public class Penguin extends Bird {
  private static int numPenguin = 0;

  public Penguin() {
    numPenguin++;
  }

  public Penguin(String nm) {
    super.setName(nm);
    numPenguin++;
  }

  public static int getNum() {
    return numPenguin;
  }
}
