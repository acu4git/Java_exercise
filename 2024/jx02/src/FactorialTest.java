public class FactorialTest {
  private static int ARRAY_SIZE = 10;

  public static void main(String[] args) {
    Factorial[] factArr = new Factorial[ARRAY_SIZE];
    for (int i = 0; i < ARRAY_SIZE; i++) {
      factArr[i] = new Factorial();
      factArr[i].setNum(i);
    }

    factArr[0].setFact(1);
    for (int i = 1; i < ARRAY_SIZE; i++) {
      int prev = factArr[i - 1].getFact();
      factArr[i].setFact(prev * i);
    }

    for (Factorial f : factArr) {
      System.out.println(f.getNum() + "! = " + f.getFact());
    }
  }
}
