public class Student {
    private String name;
    private String surname;
    private int idNumber;
    private double gpa;

    public Student(String name, String surname, int idNumber, double gpa) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.gpa = gpa;
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

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%-6d %-12s %-10s %.2f", idNumber, surname, name, gpa);
    }
}
