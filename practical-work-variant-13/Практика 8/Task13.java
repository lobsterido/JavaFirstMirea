import java.util.Scanner;

public class Task13 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void printOdd() {
        int number = SCANNER.nextInt();
        if (number == 0) {
            return;
        }
        System.out.println(number);
        int skipped = SCANNER.nextInt();
        if (skipped == 0) {
            return;
        }
        printOdd();
    }

    public static void main(String[] args) {
        printOdd();
    }
}
