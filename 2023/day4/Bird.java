package day4;

public class Bird {
    private String name;
    private static int numBird = 0;

    public Bird() {
        numBird++;
    }

    public void setName(String nm) {
        this.name = nm;
    }

    public String getName() {
        return this.name;
    }

    public static int getNum() {
        return numBird;
    }

    public static void main(String[] argv) {
        Bird bird = new Bird();
        Chicken chicken1 = new Chicken();
        Chicken chicken2 = new Chicken();
        Penguin penguin1 = new Penguin();
        Penguin penguin2 = new Penguin();
        Penguin penguin3 = new Penguin();

        System.out.println("Number of Bird: " + Bird.getNum());
        System.out.println("Number of Chicken: " + Chicken.getNum());
        System.out.println("Number of Penguin: " + Penguin.getNum());
    }
}
