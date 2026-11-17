import java.util.regex.Pattern;

public class Task7 {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z0-9_]{8,}$");

    public static void main(String[] args) {
        System.out.println("Надёжные пароли:");
        check("F032_Password");
        check("TrySpy12");
        check("Qwerty_123");

        System.out.println();
        System.out.println("Ненадёжные пароли:");
        check("smart_pass");
        check("A007");
        check("qwerty123");
        check("QWERTY123");
        check("Qwerty!");
        check("TrySpy1");
    }

    public static boolean isStrongPassword(String value) {
        return PASSWORD_PATTERN.matcher(value).matches();
    }

    private static void check(String value) {
        System.out.printf("%-14s -> %s%n", value, isStrongPassword(value));
    }
}
