import java.util.Scanner;

public class character {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a character at position 0:");
        char ch = input.next().charAt(0);
        if (ch == 'N') {
            System.out.println("input valid");
        } else {
            System.out.println("characters");
        }

        int sum = 0;
        System.out.println("Enter integer number ");
        int number = input.nextInt();
        while (number != 0) {
            sum += number;
            System.out.println("Enter an integer number");
            number = input.nextInt();
        }
        System.out.println("the sum of number are" + sum);
    }
}