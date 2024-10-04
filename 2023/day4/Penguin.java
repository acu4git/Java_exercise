package day4;

public class Penguin extends Bird {
    private static int numPenguin = 0;

    public Penguin() {
        numPenguin++;
    }

    public static int getNum() {
        return numPenguin;
    }
}
