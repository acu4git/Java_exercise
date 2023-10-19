package day4;

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

    public void setName(String nm) { // setter（セッター）

        name = nm;

    }

    public String getName() { // getter（ゲッター）

        return name;

    }

    public void setFather(Person1 f) { // setter

        father = f;

    }

    public Person1 getFather() { // getter

        return father;

    }

    public void setMother(Person1 m) { // setter

        mother = m;

    }

    public Person1 getMother() { // getter

        return mother;

    }

    public static void main(String args[]) {

        Person1 p1 = new Person1("Mike");

        Person1 p2 = new Person1("Mary");

        Person1 p3 = new Person1("Tom", p1, p2);

        System.out.println("My name is " + p3.getName() + ".");

        System.out.println("My father's name is " + p3.getFather().getName() + ".");

        System.out.println("My mother's name is " + p3.getMother().getName() + ".");

    }

}