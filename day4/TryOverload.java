package day4;

public class TryOverload {
    private int valInt;
    private String valStr;
    private double valDouble;

    public void setValue(int val) {
        this.valInt = val;
    }

    public void setValue(String val) {
        this.valStr = val;
    }

    public void setValue(double val) {
        this.valDouble = val;
    }

    public int getValueInt() {
        return this.valInt;
    }

    public String getValueStr() {
        return this.valStr;
    }

    public double getValueDouble() {
        return this.valDouble;
    }

    public void times(int val1, int val2) {
        System.out.println(val1 + " * " + val2 + " = " + val1 * val2);
    }

    public void times(String str, int num) {
        System.out.println("(String:\"" + str + "\", int:" + num + ")");
        for (int i = 0; i < num; i++) {
            System.out.println((i + 1) + "回目: " + str);
        }
    }

    public void times(int num, String str) {
        System.out.println("(int:" + num + ", String:\"" + str + "\")");
        for (int i = 0; i < num; i++) {
            System.out.println((i + 1) + "回目: " + str);
        }
    }

    public void times(String str1, String str2) {
        System.out.println("\"" + str1 + "\"" + " + " + "\"" + str2 + "\"" + " = " + str1 + str2);
    }

    public static void main(String[] argv) {
        TryOverload tryOverload = new TryOverload();
        tryOverload.setValue(10);
        tryOverload.setValue("Eishu");
        tryOverload.setValue(3.14);

        System.out.println("Int: " + tryOverload.getValueInt());
        System.out.println("String: " + tryOverload.getValueStr());
        System.out.println("Double: " + tryOverload.getValueDouble());
        System.out.println();

        tryOverload.times(3, 4);
        tryOverload.times("Happy", 3);
        tryOverload.times(4, "Happy");
        tryOverload.times("Happy ", "Birthday!");
    }
}
