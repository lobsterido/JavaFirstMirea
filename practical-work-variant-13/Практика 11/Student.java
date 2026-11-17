import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {
    private String name;
    private String surname;
    private Date birthDate;

    public Student(String name, String surname, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFormattedBirthDate(int style) {
        DateFormat formatter = DateFormat.getDateInstance(style, new Locale("ru", "RU"));
        return formatter.format(birthDate);
    }

    @Override
    public String toString() {
        return surname + " " + name + ", дата рождения: " + getFormattedBirthDate(DateFormat.MEDIUM);
    }
}
