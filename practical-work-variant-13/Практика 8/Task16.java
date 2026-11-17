import java.util.Scanner;

public class Task16 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static class Result {
        private final int maximum;
        private final int count;

        public Result(int maximum, int count) {
            this.maximum = maximum;
            this.count = count;
        }

        public int getMaximum() {
            return maximum;
        }

        public int getCount() {
            return count;
        }
    }

    public static Result countMaximum() {
        int value = SCANNER.nextInt();
        if (value == 0) {
            return new Result(0, 0);
        }
        Result rest = countMaximum();
        if (rest.getCount() == 0 || value > rest.getMaximum()) {
            return new Result(value, 1);
        }
        if (value == rest.getMaximum()) {
            return new Result(value, rest.getCount() + 1);
        }
        return rest;
    }

    public static void main(String[] args) {
        Result result = countMaximum();
        System.out.println(result.getCount());
    }
}
