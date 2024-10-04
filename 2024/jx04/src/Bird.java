public class Bird {
  private String name;
  private static int numBird = 0;

  public Bird() {
    numBird++;
  }

  public Bird(String nm) {
    setName(nm);
    numBird++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static int getNum() {
    return numBird;
  }

  public static void main(String[] args) {
    Bird bird = new Bird("Thunder bird");
    System.out.println("bird name: " + bird.getName());
    Chicken chicken1 = new Chicken("koke");
    System.out.println("chicken1 name: " + chicken1.getName());
    Chicken chicken2 = new Chicken("kokko");
    System.out.println("chicken2 name: " + chicken2.getName());
    Penguin penguin1 = new Penguin("small penguin");
    System.out.println("penguin1 name: " + penguin1.getName());
    Penguin penguin2 = new Penguin("normal penguin");
    System.out.println("penguin2 name: " + penguin2.getName());
    Penguin penguin3 = new Penguin("big penguin");
    System.out.println("penguin3 name: " + penguin3.getName());

    System.out.println("Number of bird: " + Bird.getNum());
    System.out.println("Number of chicken: " + Chicken.getNum());
    System.out.println("Number of penguin: " + Penguin.getNum());
  }
}
