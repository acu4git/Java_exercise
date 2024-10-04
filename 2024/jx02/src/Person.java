public class Person {
  private String lastName;
  private String firstName;
  private String address;

  public void setLastName(String lname) {
    this.lastName = lname;
  }

  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String fname) {
    this.firstName = fname;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getName() {
    return firstName + " " + lastName;
  }

  public void setAddress(String add) {
    this.address = add;
  }

  public String getAddress() {
    return address;
  }

  public void print() {
    System.out.println("Name: " + getName());
    System.out.println("Address: " + getAddress());
  }
}
