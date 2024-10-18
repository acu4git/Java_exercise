import java.awt.event.*;

class TryEvent2 implements ActionListener {
  private String message;

  TryEvent2() {
  }

  TryEvent2(String str) {
    message = str;
  }

  public void actionPerformed(ActionEvent e) { // ActionListenerの場合，イベントが発生するとこのメソッドが呼ばれる
    System.out.println(message);
  }
}