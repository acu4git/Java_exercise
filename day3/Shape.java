public class Shape {
    // attribute
    private String name;

    // method
    public void setName(String nm) {
        name = nm;
    }

    public String getName() {
        return name;
    }

    public String whoareyou() {
        return "I am a " + name + ".";
    }

    public float calcArea() {
        return 0.0f;
    }

    public static void main(String[] args) {
        Shape s1 = new Shape();
        s1.setName("Shape");

        Circle c1 = new Circle();
        c1.setName("Circle");
        c1.setRadius(5);

        Circle c2 = new Circle();
        c2.setName("Circle");
        c2.setRadius(3);

        Square sq1 = new Square();
        sq1.setName("Square");
        sq1.setSide(15);

        Shape shapeArray[] = { s1, c1, c2, sq1 };

        for (int i = 0; i < shapeArray.length; i++) {
            Shape t = shapeArray[i];
            System.out.println(t.whoareyou() + " Area = " + t.calcArea() + " sq. cm.");
        }
    }
}
