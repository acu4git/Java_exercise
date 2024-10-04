class Compare {
  public static void main(String args[]) {
    String a = new String("abc");
    String b = new String("def");
    String c = new String("abc");
    String d;

    d = a;

    System.out.println("a.equals(b): " + (a.equals(b)));
    System.out.println("  a == b   : " + (a == b));
    System.out.println("a.equals(c): " + (a.equals(c)));
    System.out.println("  a == c   : " + (a == c));
    System.out.println("a.equals(d): " + (a.equals(d)));
    System.out.println("  a == d   : " + (a == d));
  }
}