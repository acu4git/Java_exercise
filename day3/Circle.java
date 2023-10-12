public class Circle extends Shape {
    // attribute
    private int radius;

    // method
    public void setRadius(int r) {
        radius = r;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public float calcArea() {
        float r;

        r = getRadius();
        return (float) (3.14f * r * r);
    }
}