public class Task5 {
    public static void main(String[] args) {
        String[] numbers = {
                "+79175655655",
                "89175655655",
                "+104289652211"
        };

        for (String number : numbers) {
            System.out.println(number + " -> " + formatPhone(number));
        }
    }

    public static String formatPhone(String phone) {
        String digits = phone.replaceAll("[^0-9]", "");
        if (digits.length() < 11) {
            return "некорректный номер";
        }
        String number = digits.substring(digits.length() - 10);
        String countryCode = digits.substring(0, digits.length() - 10);
        if ("8".equals(countryCode)) {
            countryCode = "7";
        }
        return "+" + countryCode + " "
                + number.substring(0, 3) + "-"
                + number.substring(3, 6) + "-"
                + number.substring(6);
    }
}
