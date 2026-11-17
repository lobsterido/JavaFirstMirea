public class Task1 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Анна", "Иванова", 4, 4.6),
                new Student("Пётр", "Смирнов", 1, 4.1),
                new Student("Мария", "Кузнецова", 6, 4.9),
                new Student("Иван", "Соколов", 2, 3.8),
                new Student("Ольга", "Попова", 5, 4.4),
                new Student("Григорий", "Лобасов", 3, 5.0)
        };

        System.out.println("Массив до сортировки:");
        print(students);

        insertionSort(students);

        System.out.println("Массив после сортировки вставками по номеру студенческого:");
        print(students);
    }

    public static void insertionSort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student current = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].getIdNumber() > current.getIdNumber()) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = current;
        }
    }

    public static void print(Student[] students) {
        System.out.println("ID     Фамилия      Имя        Балл");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
