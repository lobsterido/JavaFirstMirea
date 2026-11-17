import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        System.out.print("Введите месяц (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Введите число: ");
        int day = scanner.nextInt();
        System.out.print("Введите часы: ");
        int hours = scanner.nextInt();
        System.out.print("Введите минуты: ");
        int minutes = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month - 1, day, hours, minutes);

        Date date = calendar.getTime();

        System.out.println("Объект Calendar: " + formatter.format(calendar.getTime()));
        System.out.println("Объект Date: " + formatter.format(date));
        System.out.println("Миллисекунды с 01.01.1970: " + date.getTime());
    }
}
