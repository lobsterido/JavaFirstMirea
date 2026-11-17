import java.util.Scanner;

public class Card {
    private String fullName;
    private String group;
    private double averageGrade;

    public Card() {
    }

    public Card(String fullName, String group, double averageGrade) {
        this.fullName = fullName;
        this.group = group;
        this.averageGrade = averageGrade;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void readFromConsole(Scanner scanner) {
        System.out.print("ФИО: ");
        fullName = scanner.nextLine().trim();
        System.out.print("Группа: ");
        group = scanner.nextLine().trim();
        System.out.print("Средний балл: ");
        averageGrade = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
    }

    public void print() {
        System.out.printf("%-32s %-10s %.2f%n", fullName, group, averageGrade);
    }

    @Override
    public String toString() {
        return fullName + " " + group + " " + averageGrade;
    }
}
