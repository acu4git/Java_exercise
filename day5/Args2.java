package day5;

public class Args2 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }

        int valInt;
        double valDouble;
        String valStr;

        for (int i = 0; i < args.length; i++) {
            // 各桁が数値のみかどうかを正規表現で判定
            boolean isOnlyDigit = args[i].matches("[0-9]+");
            if (isOnlyDigit) {
                if (args[i].length() > 1 && args[i].substring(0, 1).equals("0")) {
                    valStr = args[i];
                    System.out.println(valStr + " : String");
                } else {
                    valInt = Integer.parseInt(args[i]);
                    System.out.println(valInt + " : int");
                }
            } else {
                try {
                    valDouble = Double.parseDouble(args[i]);
                    System.out.println(valDouble + " : double");
                } catch (NumberFormatException e) {
                    valStr = args[i];
                    System.out.println(valStr + " : String");
                }
            }
        }
    }
}
