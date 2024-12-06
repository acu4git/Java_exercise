import javax.swing.*;

public class CalcCtrl {
  private CalcModel mdl;
  private String errInvalidOperation = "Error: invalid operation";

  CalcCtrl() {
    // mdl = new CalcModel();
  }

  public void setCalcModel(CalcModel mdl) {
    this.mdl = mdl;
  }

  String calc(JTextField tf1, JTextField tfop, JTextField tf2) {
    String res = "";
    String op = tfop.getText();
    switch (op) {
      case "+":
        res += mdl.plus(tf1, tf2);
        break;
      case "-":
        res += mdl.minus(tf1, tf2);
        break;
      case "*":
        res += mdl.multi(tf1, tf2);
        break;
      case "/":
        res += mdl.divide(tf1, tf2);
        break;
      default:
        res += errInvalidOperation;
    }

    return res;
  }
}
