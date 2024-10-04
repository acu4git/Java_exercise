public class DogTest {
  public static void main(String[] args) {
    Dog d1 = new Dog();
    d1.setName("taro");
    d1.setVoice("WonWon");
    System.out.println(d1.getName() + " barks " + d1.getVoice());

    Dog d2 = new Dog();
    d2.setName("Pochi");
    System.out.println(d2.getName() + " barks " + d2.getVoice());
    d2.setVoice("Bowwow");
    System.out.println(d2.getName() + " barks " + d2.getVoice());
  }
}
