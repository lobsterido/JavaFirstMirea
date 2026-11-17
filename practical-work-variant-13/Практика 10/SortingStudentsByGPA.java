import java.util.Arrays;
import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    private Student[] iDNumber;

    @Override
    public int compare(Student first, Student second) {
        return Double.compare(second.getGpa(), first.getGpa());
    }

    public static void main(String[] args) {
        SortingStudentsByGPA tester = new SortingStudentsByGPA();

        tester.setArray();
        System.out.println("Исходный массив студентов:");
        tester.outArray();

        tester.quicksort();
        System.out.println("После быстрой сортировки по среднему баллу (по убыванию):");
        tester.outArray();

        tester.setArray();
        tester.mergeSort();
        System.out.println("После сортировки слиянием по среднему баллу (по убыванию):");
        tester.outArray();

        tester.sortBySurname();
        System.out.println("После сортировки по фамилии:");
        tester.outArray();
    }

    public void setArray() {
        iDNumber = new Student[]{
                new Student("Анна", "Иванова", "Прикладная информатика", 2, "ПИ-21", 4.6),
                new Student("Пётр", "Смирнов", "Программная инженерия", 1, "ПИ-11", 4.1),
                new Student("Мария", "Кузнецова", "Информационные системы", 3, "ИС-31", 4.9),
                new Student("Иван", "Соколов", "Прикладная информатика", 2, "ПИ-22", 3.8),
                new Student("Ольга", "Попова", "Программная инженерия", 1, "ПИ-12", 4.4),
                new Student("Григорий", "Лобасов", "Информационные системы", 3, "ИС-32", 5.0)
        };
    }

    public void quicksort() {
        quicksort(iDNumber, 0, iDNumber.length - 1);
    }

    private void quicksort(Student[] students, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(students, low, high);
            quicksort(students, low, pivotIndex - 1);
            quicksort(students, pivotIndex + 1, high);
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

    public void mergeSort() {
        if (iDNumber.length < 2) {
            return;
        }
        mergeSort(iDNumber, 0, iDNumber.length - 1);
    }

    private void mergeSort(Student[] students, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(students, left, middle);
            mergeSort(students, middle + 1, right);
            merge(students, left, middle, right);
        }
    }

    private void merge(Student[] students, int left, int middle, int right) {
        Student[] leftPart = Arrays.copyOfRange(students, left, middle + 1);
        Student[] rightPart = Arrays.copyOfRange(students, middle + 1, right + 1);
        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftPart.length && j < rightPart.length) {
            if (compare(leftPart[i], rightPart[j]) <= 0) {
                students[k++] = leftPart[i++];
            } else {
                students[k++] = rightPart[j++];
            }
        }
        while (i < leftPart.length) {
            students[k++] = leftPart[i++];
        }
        while (j < rightPart.length) {
            students[k++] = rightPart[j++];
        }
    }

    public void sortBySurname() {
        Arrays.sort(iDNumber, Comparator.comparing(Student::getSurname));
    }

    public void outArray() {
        System.out.println("Фамилия      Имя        Специальность          Курс   Группа   Балл");
        for (Student student : iDNumber) {
            System.out.println(student);
        }
        System.out.println();
    }
}
