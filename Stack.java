import java.util.*;

public class Stack {
	static Scanner scan = new Scanner(System.in);
	static int[] stacks = new int[5];
	static int currentStacks = 0;

	public static void main(String[] args) {
		choice();
	}

	public static void choice() {
		boolean doLoop = true;
		printAll();
		while(doLoop) {
			System.out.print("Input your choice: ");
			if (scan.hasNextInt()) {
				int choice = scan.nextInt();
				if (choice < 0 || choice > 9) {
					System.out.println("Invalid choice");
					return;
				}

				switch (choice) {
					case 0: System.out.println("Program terminated."); return;
					case 1: push(); break;
					case 2: pop(); break;
					case 3: getLargest(); break;
					case 4: getSmallest(); break;
					case 5: allEvenNumbers(); break;
					case 6: allOddNumbers(); break;
					case 7: totalNumbers(); break;
					case 8: averageNumbers(); break;
					case 9: searchElements(); break;
				}

			} else System.out.println("Input must be integer");
		}
	}

	public static void searchElements() {
		System.out.print("Input element: ");
		if (!scan.hasNextInt()) {
			System.out.println("Input must be a number");
			scan.next();
			return;
		}

		int input = scan.nextInt();
		if (input <= 0) {
			System.out.println("Input must be greater than zero");
			return;
		}

		int index = 0;
		boolean elementFound = false;
		for (int i = 0; i < currentStacks; i++) {
			if (input == stacks[i]) {
				elementFound = true;
				break;
			}
			index++;
		}

		if (elementFound == false) {
			System.out.println("Element not found");
			return;
		}

		System.out.println("Element " + input + " at index " + index);
	}

	public static void averageNumbers() {
		int total = 0;
		float ave = 0;
		for (int i = 0; i < currentStacks; i++) {
			total += stacks[i];
		}
		ave = (float) total / currentStacks;
		System.out.println("Total of all numbers: " + ave);
	}

	public static void totalNumbers() {
		int total = 0;
		for (int i = 0; i < currentStacks; i++) {
			total += stacks[i];
		}
		System.out.println("Total of all numbers: " + total);
	}

	public static void allOddNumbers() {
		int odds = 0;
		System.out.print("All odd numbers: ");
		for (int i = 0; i < currentStacks; i++) {
			if (stacks[i] % 2 != 0) {
				System.out.print(stacks[i] + " ");
				odds++;
			}
		}

		if (odds == 0) {
			System.out.print("no odd numbers");
		}

		System.out.println();
	}

	public static void allEvenNumbers() {
		int evens = 0;
		System.out.print("All even numbers: ");
		for (int i = 0; i < currentStacks; i++) {
			if (stacks[i] % 2 == 0) {
				System.out.print(stacks[i] + " ");
				evens++;
			}
		}

		if (evens == 0) {
			System.out.print("no even numbers");
		}

		System.out.println();
	}

	public static void getSmallest() {
		if (currentStacks == 0) {
			System.out.println("No elements.");
			return;
		}

		int smallest = stacks[0];
		for (int i = 1; i < currentStacks; i++) {
			if (stacks[i] < smallest) {
				smallest = stacks[i];
			}
		}
		System.out.println("Smallest number: " + smallest);
	}

	public static void getLargest() {
		if (currentStacks == 0) {
			System.out.println("No elements.");
			return;
		}

		int largest = stacks[0];
		for (int i = 1; i < currentStacks; i++) {
			if (stacks[i] > largest) {
				largest = stacks[i];
			}
		}
		System.out.println("Largest number: " + largest);
	}

	public static void pop() {
		if (currentStacks == 0) {
			System.out.println("Cannot pop, there's no stack");
			return;
		}

		stacks[0] = 0;

		for (int i = 0; i < currentStacks-1; i++) {
			stacks[i] = stacks[i + 1];
		}

		stacks[currentStacks - 1] = 0;
		currentStacks--;

		printAll();
		System.out.println("Value popped from stack.");
	}

	public static void push() {
		if (currentStacks == stacks.length) {
			System.out.println("Cannot push, Stack is full");
			return;
		}

		System.out.print("Input a value to push: ");
		if (!scan.hasNextInt()) {
			System.out.println("Input must be an integer");
			scan.next();
			return;
		}

		int input = scan.nextInt();
		if (input == 0) {
			System.out.println("Input must not be zero");
			return;
		}

		for (int i = currentStacks - 1; i >= 0; i--) {
			stacks[i + 1] = stacks[i];
		}

		stacks[0] = input;
		currentStacks++;

		printAll();
		System.out.println("A value added successfully!");
	}

	public static void printAll() {
		for (int i = 0; i < stacks.length; i++) {
			System.out.println("			---------------------------------");
			System.out.println("			|		" + stacks[i]+"		|");
			System.out.println("			---------------------------------");
		}

		System.out.println("Pick a choice: ");
		System.out.println("[1] to push				[6] to print all odd numbers");
		System.out.println("[2] to pop				[7] to total all numbers");
		System.out.println("[3] to find the largest			[8] to find the average");
		System.out.println("[4]	to find the smallest		[9] to search element");
		System.out.println("[5] to print all even numbers		[0] to exit");
	}
}