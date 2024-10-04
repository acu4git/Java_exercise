package day4;

class Args {
    public static void main(String[] args) {
        String valStr;
        int valInt;
        double valDouble;

        valStr = args[0];
        valInt = Integer.parseInt(args[1]);
        valDouble = Double.parseDouble(args[2]);

        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
        System.out.println();
        System.out.println("valStr = " + valStr);
        System.out.println("valInt = " + valInt);
        System.out.println("valDouble = " + valDouble);
    }
}