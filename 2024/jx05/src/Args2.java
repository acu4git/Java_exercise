import java.util.ArrayList;

public class Args2 {
  public static void main(String[] args) {
    ArrayList<Object> valList = new ArrayList<>();

    for (int i = 1; i < args.length; i++) {
      Object valObj = null;
      try {
        valObj = Integer.parseInt(args[i]);
        System.out.println(args[i] + " is a integer.");
      } catch (NumberFormatException e1) {
        try {
          valObj = Double.parseDouble(args[i]);
          System.out.println(args[i] + " is a double.");
        } catch (NumberFormatException e2) {
          valObj = args[i];
          System.out.println(args[i] + " is a string.");
        }
      } finally {
        valList.add(valObj);
      }
    }

    for (int i = 0; i < valList.size(); i++) {
      System.out
          .println("args[" + (i + 1) + "] = " + valList.get(i) + "(type " + valList.get(i).getClass().getName() + ")");
    }
  }
}
