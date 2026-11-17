import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task1 {
    public static void main(String[] args) {
        String developer = "Лобасов Г.Г.";
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2026, Calendar.NOVEMBER, 10, 9, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date received = calendar.getTime();

        Date submitted = new Date();

        System.out.println("Разработчик: " + developer);
        System.out.println("Задание получено: " + formatter.format(received));
        System.out.println("Задание сдано: " + formatter.format(submitted));
    }
}
