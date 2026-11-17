import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task5 {
    private static final int OPERATIONS = 20000;

    private interface Operation {
        void run(List<Integer> list);
    }

    public static void main(String[] args) {
        System.out.printf("%-32s %14s %14s%n", "Операция", "ArrayList, мс", "LinkedList, мс");
        compare("Добавление в конец", Task5::addToEnd);
        compare("Добавление в начало", Task5::addToBeginning);
        compare("Вставка в середину", Task5::insertInMiddle);
        compare("Поиск элемента", Task5::search);
        compare("Удаление из начала", Task5::removeFromBeginning);
        compare("Удаление из середины", Task5::removeFromMiddle);
    }

    private static void compare(String name, Operation operation) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < OPERATIONS; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long arrayTime = measure(arrayList, operation);
        long linkedTime = measure(linkedList, operation);

        System.out.printf("%-32s %14.3f %14.3f%n",
                name, arrayTime / 1_000_000.0, linkedTime / 1_000_000.0);
    }

    private static long measure(List<Integer> list, Operation operation) {
        long start = System.nanoTime();
        operation.run(list);
        return System.nanoTime() - start;
    }

    private static void addToEnd(List<Integer> list) {
        for (int i = 0; i < OPERATIONS; i++) {
            list.add(i);
        }
    }

    private static void addToBeginning(List<Integer> list) {
        for (int i = 0; i < OPERATIONS; i++) {
            list.add(0, i);
        }
    }

    private static void insertInMiddle(List<Integer> list) {
        for (int i = 0; i < OPERATIONS; i++) {
            list.add(list.size() / 2, i);
        }
    }

    private static void search(List<Integer> list) {
        for (int i = 0; i < OPERATIONS; i++) {
            list.contains(-1);
        }
    }

    private static void removeFromBeginning(List<Integer> list) {
        for (int i = 0; i < OPERATIONS && !list.isEmpty(); i++) {
            list.remove(0);
        }
    }

    private static void removeFromMiddle(List<Integer> list) {
        for (int i = 0; i < OPERATIONS && !list.isEmpty(); i++) {
            list.remove(list.size() / 2);
        }
    }
}
