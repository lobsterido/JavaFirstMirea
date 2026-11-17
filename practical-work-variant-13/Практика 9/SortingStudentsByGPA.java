import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student first, Student second) {
        return Double.compare(second.getGpa(), first.getGpa());
    }

    public void quickSort(Student[] students) {
        quickSort(students, 0, students.length - 1);
    }

    private void quickSort(Student[] students, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(students, low, high);
            quickSort(students, low, pivotIndex - 1);
            quickSort(students, pivotIndex + 1, high);
        }
    }

    private int partition(Student[] students, int low, int high) {
        Student pivot = students[high];
        int smaller = low - 1;
        for (int i = low; i < high; i++) {
            if (compare(students[i], pivot) <= 0) {
                smaller++;
                swap(students, smaller, i);
            }
        }
        swap(students, smaller + 1, high);
        return smaller + 1;
    }

    private void swap(Student[] students, int first, int second) {
        Student temporary = students[first];
        students[first] = students[second];
        students[second] = temporary;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Анна", "Иванова", 4, 4.6),
                new Student("Пётр", "Смирнов", 1, 4.1),
                new Student("Мария", "Кузнецова", 6, 4.9),
                new Student("Иван", "Соколов", 2, 3.8),
                new Student("Ольга", "Попова", 5, 4.4),
                new Student("Григорий", "Лобасов", 3, 5.0)
        };

        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        System.out.println("Студенты до быстрой сортировки:");
        print(students);

        sorter.quickSort(students);

        System.out.println("Студенты после быстрой сортировки по среднему баллу (по убыванию):");
        print(students);
    }

    public static void print(Student[] students) {
        System.out.println("ID     Фамилия      Имя        Балл");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
