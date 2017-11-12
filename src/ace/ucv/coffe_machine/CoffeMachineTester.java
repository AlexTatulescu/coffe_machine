package ace.ucv.coffe_machine;

import java.util.Scanner;

public class CoffeMachineTester {

	public static void main(String[] args) {

		CoffeMachine coffeMachine = new CoffeMachine();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insert the coins: ");

		while (true) {
			coffeMachine.transition(scanner.next());
		}

	}

}
