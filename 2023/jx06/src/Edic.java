import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Edic extends JFrame implements ActionListener {
    Container c;
    JTextField tf;
    JButton transButton;
    JButton clearButton;
    JButton quiButton;
    JLabel resultLabel;

    Edic() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 150);
        setTitle("Edic");

        c = getContentPane();
        c.setLayout(new FlowLayout());

        tf = new JTextField("", 20);
        transButton = new JButton("Translate");
        clearButton = new JButton("Clear");
        quiButton = new JButton("Quit");
        resultLabel = new JLabel("");
        c.add(tf);
        c.add(transButton);
        c.add(clearButton);
        c.add(quiButton);
        c.add(resultLabel);

        transButton.addActionListener(this);
        clearButton.addActionListener(this);
        quiButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == transButton) {
            String text = tf.getText();
            String wordJA, wordEN;

            // debug
            System.out.println("Entered text: " + text + "\n");

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/dic.txt"));) {
                while ((wordEN = bufferedReader.readLine()) != null) {
                    System.out.println(wordEN);
                    if (text.equals(wordEN)) {
                        wordJA = bufferedReader.readLine();
                        resultLabel.setText(wordJA);
                        return;
                    }
                    bufferedReader.readLine();
                }
                resultLabel.setText("Cannot translate \"" + text + "\".");
            } catch (IOException e) {
                e.printStackTrace();
                resultLabel.setText("Not found any dictionary.");
            }
        } else if (event.getSource() == clearButton) {
            tf.setText("");
        } else if (event.getSource() == quiButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Edic edic = new Edic();
        edic.setVisible(true);
    }
}
