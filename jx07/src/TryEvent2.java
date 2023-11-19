import java.awt.event.*;

public class TryEvent2 implements ActionListener {
    private String message;

    TryEvent2() {
    }

    TryEvent2(String str) {
        message = str;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        System.out.println(message);
    }
}
