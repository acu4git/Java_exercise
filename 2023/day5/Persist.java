package day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Persist {
    public static void main(String[] args) {
        String buff;
        try (
                BufferedWriter buffWriter = new BufferedWriter(new FileWriter("./day5/student.txt"));
                BufferedReader buffKeyboard = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println("文字列を入力してください（qで終了します）");
            while (true) {
                System.out.print("学籍番号: ");
                buff = buffKeyboard.readLine();
                if (buff.equals("q")) {
                    break;
                }
                buffWriter.write(buff);
                buffWriter.write(" ");

                System.out.print("氏名: ");
                buff = buffKeyboard.readLine();
                if (buff.equals("q")) {
                    break;
                }
                buffWriter.write(buff);
                buffWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error.");
        }
    }
}
