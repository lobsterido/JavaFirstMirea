import java.util.Scanner;

public class Task17 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int maximum() {
        int value = SCANNER.nextInt();
        if (value == 0) {
            return 0;
        }
        int nextMaximum = maximum();
        return Math.max(value, nextMaximum);
    }

    public static void main(String[] args) {
        System.out.println(maximum());
    }
}
