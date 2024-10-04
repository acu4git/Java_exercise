public class Chicken extends Bird {
  private static int numChicken = 0;

  public Chicken() {
    numChicken++;
  }

  public Chicken(String nm) {
    super.setName(nm);
    numChicken++;
  }

  public static int getNum() {
    return numChicken;
  }
}