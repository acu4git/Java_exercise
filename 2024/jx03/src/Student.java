public class Student extends Person {
  private String school;
  private int grade;
  private String number;

  public void setSchool(String sname) {
    this.school = sname;
  }

  public String getSchool() {
    return this.school;
  }

  public void setGrade(int gd) {
    this.grade = gd;
  }

  public int getGrade() {
    return this.grade;
  }

  public void setNumber(String no) {
    this.number = no;
  }

  public String getNumber() {
    return this.number;
  }

  @Override
  public void print() {
    super.print();
    System.out.println("School: " + getSchool());
    System.out.println("Grade: " + getGrade());
    System.out.println("Student Number: " + getNumber());
  }

  public static void main(String[] args) {
    Student st = new Student();
    st.setFirstName("Eishu");
    st.setLastName("Kawaguchi");
    st.setAddress("Hirakicho, Nishinomiya, Hyogo");
    st.setSchool("Kyoto Institute of Technology");
    st.setGrade(3);
    st.setNumber("22122502");

    System.out.println("getFirstName(): " + st.getFirstName());
    System.out.println("getLastName(): " + st.getLastName());
    System.out.println("getName(): " + st.getName());
    System.out.println("getAddress(): " + st.getAddress());
    System.out.println("getSchool(): " + st.getSchool());
    System.out.println("getGrade(): " + st.getGrade());
    System.out.println("getNumber(): " + st.getNumber());

    System.out.println("=========================================");
    st.print();
  }
}
