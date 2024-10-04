package day2;

public class Person {
	private String lastName, firstName, address;

	public void setLastName(String lName) {
		this.lastName = lName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public void setAddress(String add) {
		this.address = add;
	}

	public String getAddress() {
		return this.address;
	}

	public void print() {
		System.out.println("Name: " + this.getName());
		System.out.println("Address: " + this.getAddress());
	}
}
