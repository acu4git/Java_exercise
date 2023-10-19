package day2;

public class FactorialTest {

	public static void main(String[] args) {
		Factorial[] factorial = new Factorial[10];
		for (int i = 0; i < 10; i++) {
			factorial[i] = new Factorial();
			factorial[i].setNum(i);
		}
		factorial[0].setFact(1);
		for (int i = 1; i < 10; i++) {
			int fact = factorial[i - 1].getFact();
			int num = factorial[i].getNum();
			factorial[i].setFact(fact * num);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("num of factorial[" + i + "]: " + factorial[i].getNum());
			System.out.println(i + "! = " + factorial[i].getFact());
			System.out.println("");
		}
	}

}
