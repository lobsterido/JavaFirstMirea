import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Task3 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Student student = new Student("Григорий", "Лобасов", formatter.parse("15.03.2005"));

        System.out.println(student);
        System.out.println("Короткий формат: " + student.getFormattedBirthDate(DateFormat.SHORT));
        System.out.println("Средний формат: " + student.getFormattedBirthDate(DateFormat.MEDIUM));
        System.out.println("Полный формат: " + student.getFormattedBirthDate(DateFormat.FULL));
    }
}
