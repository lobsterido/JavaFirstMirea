import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Student> firstList = new ArrayList<>();
        firstList.add(new Student("Анна", "Иванова", 4, 4.6));
        firstList.add(new Student("Пётр", "Смирнов", 1, 4.1));
        firstList.add(new Student("Мария", "Кузнецова", 6, 4.9));

        List<Student> secondList = new ArrayList<>();
        secondList.add(new Student("Иван", "Соколов", 2, 3.8));
        secondList.add(new Student("Ольга", "Попова", 5, 4.4));
        secondList.add(new Student("Григорий", "Лобасов", 3, 5.0));

        System.out.println("Первый список до сортировки:");
        print(firstList);

        System.out.println("Второй список до сортировки:");
        print(secondList);

        mergeSort(firstList);
        mergeSort(secondList);

        System.out.println("Первый список после сортировки слиянием:");
        print(firstList);

        System.out.println("Второй список после сортировки слиянием:");
        print(secondList);

        List<Student> mergedList = mergeLists(firstList, secondList);

        System.out.println("Объединённый отсортированный список:");
        print(mergedList);
    }

    public static void mergeSort(List<Student> students) {
        if (students.size() < 2) {
            return;
        }
        int middle = students.size() / 2;
        List<Student> left = new ArrayList<>(students.subList(0, middle));
        List<Student> right = new ArrayList<>(students.subList(middle, students.size()));

        mergeSort(left);
        mergeSort(right);
        mergeSorted(left, right, students);
    }

    private static void mergeSorted(List<Student> left, List<Student> right, List<Student> result) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getGpa() >= right.get(j).getGpa()) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }

    public static List<Student> mergeLists(List<Student> first, List<Student> second) {
        List<Student> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < first.size() && j < second.size()) {
            if (first.get(i).getGpa() >= second.get(j).getGpa()) {
                result.add(first.get(i++));
            } else {
                result.add(second.get(j++));
            }
        }
        while (i < first.size()) {
            result.add(first.get(i++));
        }
        while (j < second.size()) {
            result.add(second.get(j++));
        }
        return result;
    }

    public static void print(List<Student> students) {
        System.out.println("ID     Фамилия      Имя        Балл");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
