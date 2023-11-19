import java.awt.*;
import javax.swing.*;

class MyEditor {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ViewPanel panel = new ViewPanel();
        Container container = frame.getContentPane();
        container.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MyEditor");
        frame.setSize(600, 600);
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setVisible(true);
    }
}