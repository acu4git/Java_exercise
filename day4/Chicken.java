package day4;

public class Chicken extends Bird {
    private static int numChicken = 0;

    public Chicken() {
        numChicken++;
    }

    public static int getNum() {
        return numChicken;
    }
}
