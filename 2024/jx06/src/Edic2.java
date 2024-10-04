import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.PatternSyntaxException;
import java.awt.*;
import javax.swing.*;

public class Edic2 extends JFrame implements ActionListener {
  private Container c;
  private JTextField textField;
  private JButton btnTrans, btnClear, btnQuit;
  private JLabel transLabel;
  private JPanel p;
  private HashMap<String, String> dictionary;

  private void setLabel(String str) {
    transLabel.setText(str);
  }

  Edic2() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 200);
    setTitle("Edic");

    c = getContentPane();
    c.setLayout(new GridLayout(3, 1));
    p = new JPanel(new FlowLayout());
    dictionary = new HashMap<>();

    textField = new JTextField("", 12);
    btnTrans = new JButton("Translate");
    btnClear = new JButton("Clear");
    btnQuit = new JButton("Quit");
    transLabel = new JLabel("");
    p.add(btnTrans);
    p.add(btnClear);
    p.add(btnQuit);

    c.add(textField);
    c.add(p);
    c.add(transLabel);

    btnTrans.addActionListener(this);
    btnClear.addActionListener(this);
    btnQuit.addActionListener(this);
  }

  private void translate(String word) {
    String rowStr = null;
    String[] tokens = new String[2];

    System.out.println("target word: " + word);
    if (dictionary.containsKey(word)) {
      System.out.println("Success to use hashMap!");
      setLabel(dictionary.get(word));
      return;
    }

    try (BufferedReader buffReader = new BufferedReader(new FileReader("dic.txt"));) {
      while (true) {
        rowStr = buffReader.readLine();
        if (rowStr == null) {
          System.out.println("No translation found.");
          setLabel("Error: no translation found");
          break;
        }

        tokens = rowStr.split(" ");
        // debug
        System.out.println("tokens[0]: " + tokens[0]);
        if (tokens[0].equals(word)) {
          dictionary.put(word, tokens[1]);
          setLabel(tokens[1]);
          System.out.println("result: " + tokens[1]);
          break;
        }
      }
    } catch (PatternSyntaxException e) {
      System.out.println("found invalid regexp.");
      System.out.println(e.getDescription());
    } catch (IOException e) {
      System.out.println("input/output error occured.");
      System.out.println(e.getMessage());
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnTrans) {
      translate(textField.getText());
    } else if (e.getSource() == btnClear) {
      textField.setText("");
    } else if (e.getSource() == btnQuit) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    Edic2 edic = new Edic2();
    edic.setVisible(true);
  }
}
