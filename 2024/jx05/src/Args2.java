public class Args2 {
  public static void main(String[] args) {
    String valStr;
    int valInt;
    double valDouble;

    if (args.length != 3) {
      System.err.println("Invalid args");
      System.exit(1);
    }

    try {
      valStr = args[0];
      valInt = Integer.parseInt(args[1]);
      valDouble = Double.parseDouble(args[2]);

      for (int i = 0; i < args.length; i++) {
        System.out.println("args[" + i + "] = " + args[i]);
      }
      System.out.println();
      System.out.println("valStr = " + valStr);
      System.out.println("valInt = " + valInt);
      System.out.println("valDouble = " + valDouble);
    } catch (NumberFormatException e) {
      System.out.println("Error: failed to parse string");
    }
  }
}
