public class Person1 {

  // インスタンス変数

  private String name;
  private Person1 father;
  private Person1 mother;

  Person1() {
  }

  Person1(String nm) {
    setName(nm);
  }

  Person1(String nm, Person1 f, Person1 m) {
    setName(nm);
    setFather(f);
    setMother(m);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Person1 getFather() {
    return father;
  }

  public void setFather(Person1 father) {
    this.father = father;
  }

  public Person1 getMother() {
    return mother;
  }

  public void setMother(Person1 mother) {
    this.mother = mother;
  }

  public static void main(String args[]) {

    Person1 p1 = new Person1("Mike");

    Person1 p2 = new Person1("Mary");

    Person1 p3 = new Person1("Tom", p1, p2);

    System.out.println("My name is " + p3.getName() + ".");

    System.out.println("My father's name is " + (p3.getFather()).getName() + ".");

    System.out.println("My mother's name is " + (p3.getMother()).getName() + ".");

  }

}