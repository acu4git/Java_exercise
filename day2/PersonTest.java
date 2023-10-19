package day2;

public class PersonTest {

	public static void main(String[] args) {
		Person person = new Person();
		person.setLastName("Kawaguchi");
		person.setFirstName("Eishu");
		person.setAddress("Hirakicho, Nishinomiya, Hyogo");
		System.out.println("Name: " + person.getName());
		System.out.println("Address: " + person.getAddress());
		System.out.println("----------以下、print文------------");
		person.print();
	}

}
