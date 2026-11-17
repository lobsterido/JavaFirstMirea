import java.util.regex.Pattern;

public class Task6 {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
                    + "@[A-Za-z0-9]([A-Za-z0-9-]*[A-Za-z0-9])?"
                    + "(\\.[A-Za-z0-9]([A-Za-z0-9-]*[A-Za-z0-9])?)*$");

    public static void main(String[] args) {
        System.out.println("Корректные адреса:");
        check("user@example.com");
        check("root@localhost");
        check("user.name+tag@example.co.uk");

        System.out.println();
        System.out.println("Некорректные адреса:");
        check("myhost@@@com.ru");
        check("@my.ru");
        check("Julia String");
        check("user@.com");
    }

    public static boolean isEmail(String value) {
        return EMAIL_PATTERN.matcher(value).matches();
    }

    private static void check(String value) {
        System.out.printf("%-26s -> %s%n", value, isEmail(value));
    }
}
