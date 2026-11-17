import java.util.Scanner;

public class Task15 {
    public static void printDigitsReversed(int number) {
        System.out.print(number % 10 + " ");
        if (number >= 10) {
            printDigitsReversed(number / 10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число: ");
        int number = scanner.nextInt();
        printDigitsReversed(number);
        System.out.println();
    }
}
