import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        formatter.setLenient(false);

        System.out.print("Введите дату в формате dd.MM.yyyy: ");
        String input = scanner.nextLine();

        try {
            Date userDate = formatter.parse(input);
            Calendar today = Calendar.getInstance();
            Calendar entered = Calendar.getInstance();
            entered.setTime(userDate);

            clearTime(today);
            clearTime(entered);

            long difference = (entered.getTimeInMillis() - today.getTimeInMillis()) / (24L * 60 * 60 * 1000);

            System.out.println("Текущая дата: " + formatter.format(today.getTime()));
            System.out.println("Введённая дата: " + formatter.format(entered.getTime()));

            if (difference > 0) {
                System.out.println("Введённая дата позже текущей на " + difference + " дн.");
            } else if (difference < 0) {
                System.out.println("Введённая дата раньше текущей на " + Math.abs(difference) + " дн.");
            } else {
                System.out.println("Введённая дата совпадает с текущей.");
            }
        } catch (ParseException exception) {
            System.out.println("Некорректная дата.");
        }
    }

    private static void clearTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }
}
