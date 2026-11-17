import java.util.Scanner;

public class Task14 {
    public static void printDigits(int number) {
        if (number < 10) {
            System.out.print(number + " ");
            return;
        }
        printDigits(number / 10);
        System.out.print(number % 10 + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число: ");
        int number = scanner.nextInt();
        printDigits(number);
        System.out.println();
    }
}
