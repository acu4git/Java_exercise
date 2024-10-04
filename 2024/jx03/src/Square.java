public class Square extends Shape {
  private int side;

  public int getSide() {
    return this.side;
  }

  public void setSide(int l) {
    this.side = l;
  }

  @Override
  public float calcArea() {
    return (float) getSide() * getSide();
  }
}
