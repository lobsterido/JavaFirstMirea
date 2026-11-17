import java.util.regex.Pattern;

public class Task5 {
    private static final Pattern DATE_PATTERN = Pattern.compile(
            "^(("
                    + "((0[1-9]|[12][0-9]|3[01])/(0[13578]|1[02])"
                    + "|(0[1-9]|[12][0-9]|30)/(0[469]|11)"
                    + "|(0[1-9]|1[0-9]|2[0-8])/02)"
                    + "/(19[0-9]{2}|[2-9][0-9]{3}))"
                    + "|(29/02/((19|[2-9][0-9])(0[48]|[2468][048]|[13579][26])"
                    + "|([2468][048]|[13579][26])00))"
                    + ")$");

    public static void main(String[] args) {
        System.out.println("Корректные даты:");
        check("29/02/2000");
        check("30/04/2003");
        check("01/01/2003");
        check("31/12/9999");
        check("29/02/2004");

        System.out.println();
        System.out.println("Некорректные даты:");
        check("29/02/2001");
        check("30-04-2003");
        check("1/1/1899");
        check("31/04/2003");
        check("29/02/1900");
        check("32/01/2003");
    }

    public static boolean isDate(String value) {
        return DATE_PATTERN.matcher(value).matches();
    }

    private static void check(String value) {
        System.out.printf("%-12s -> %s%n", value, isDate(value));
    }
}
