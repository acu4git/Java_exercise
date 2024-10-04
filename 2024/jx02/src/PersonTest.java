public class PersonTest {
  public static void main(String[] args) {
    Person p = new Person();
    p.setFirstName("Eishu");
    p.setLastName("Kawaguchi");
    p.setAddress("Hirakicho, Nishinomiya, Hyogo");

    System.out.println("getName(): " + p.getName());
    System.out.println("getAddress(): " + p.getAddress());

    p.print();
  }
}
