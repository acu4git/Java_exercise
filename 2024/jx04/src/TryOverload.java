public class TryOverload {
  private int valInt;
  private String valStr;
  private double valDouble;

  public int getValInt() {
    return valInt;
  }

  public void setValInt(int valInt) {
    this.valInt = valInt;
  }

  public String getValStr() {
    return valStr;
  }

  public void setValStr(String valStr) {
    this.valStr = valStr;
  }

  public double getValDouble() {
    return valDouble;
  }

  public void setValDouble(double valDouble) {
    this.valDouble = valDouble;
  }

  public void setValue(int val) {
    setValInt(val);
  }

  public void setValue(String val) {
    setValStr(val);
  }

  public void setValue(double val) {
    setValDouble(val);
  }

  public void times(int val1, int val2) {
    System.out.printf("times(int %d, int %d)\n", val1, val2);
    System.out.println("\t" + val1 + " * " + val2 + " = " + val1 * val2);
  }

  public void times(String str, int num) {
    System.out.printf("times(String \"%s\", int %d)\n", str, num);
    for (int i = 0; i < num; i++) {
      System.out.println("\t" + str);
    }
  }

  public void times(int num, String str) {
    System.out.printf("times(int %d, String \"%s\")\n", num, str);
    for (int i = 0; i < num; i++) {
      System.out.println("\t" + str);
    }
  }

  public void times(String str1, String str2) {
    System.out.printf("times(String \"%s\", String \"%s\")\n", str1, str2);
    System.out.println("\t" + str1 + str2);
  }

  public static void main(String[] args) {
    TryOverload to = new TryOverload();
    to.setValue(3);
    System.out.println("to.getValInt(): " + to.getValInt());
    to.setValue("hoge");
    System.out.println("to.getValStr(): " + to.getValStr());
    to.setValue(3.14);
    System.out.println("to.getValDouble(): " + to.getValDouble());

    to.times(3, 4);
    to.times("Happy", 3);
    to.times(4, "Birthday");
    to.times("Happy ", "Birthday!");
  }
}
