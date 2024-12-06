import javax.swing.JTextField;

public class CalcModel {
  private int num1, num2;
  private String errorCalc = "Error: failed to calclate";
  private String errorParseJText = "Error: failed to parse JTextField";

  CalcModel() {
    this.num1 = 0;
    this.num2 = 0;
  }

  Boolean validate(JTextField tf1, JTextField tf2) {
    try {
      num1 = Integer.parseInt(tf1.getText());
      num2 = Integer.parseInt(tf2.getText());
    } catch (NumberFormatException e) {
      System.err.println(errorParseJText);
      return false;
    }

    return true;
  }

  private Boolean isZero(int d) {
    if (d == 0)
      return true;
    else
      return false;
  }

  String plus(JTextField tf1, JTextField tf2) {
    if (!validate(tf1, tf2))
      return errorCalc;
    return String.valueOf(num1 + num2);
  }

  String minus(JTextField tf1, JTextField tf2) {
    if (!validate(tf1, tf2))
      return errorCalc;
    return String.valueOf(num1 - num2);
  }

  String multi(JTextField tf1, JTextField tf2) {
    if (!validate(tf1, tf2))
      return errorCalc;
    return String.valueOf(num1 * num2);
  }

  String divide(JTextField tf1, JTextField tf2) {
    if (!validate(tf1, tf2) || isZero(num2))
      return errorCalc;
    return String.valueOf(num1 / num2);
  }
}
