import java.util.Scanner;

public class SinglyTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        while (true) {
            printMenu();
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Введите число от 0 до 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    Card card = new Card();
                    card.readFromConsole(scanner);
                    list.add(card);
                    System.out.println("Студент добавлен.");
                    break;
                case 2:
                    System.out.print("Номер студента для удаления: ");
                    int index = Integer.parseInt(scanner.nextLine().trim());
                    if (list.remove(index)) {
                        System.out.println("Студент удалён.");
                    } else {
                        System.out.println("Студента с таким номером нет.");
                    }
                    break;
                case 3:
                    list.print();
                    break;
                case 4:
                    list.clear();
                    System.out.println("Список очищен.");
                    break;
                case 5:
                    if (list.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        System.out.println("В списке студентов: " + list.size());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Нет такого пункта меню.");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента по номеру");
        System.out.println("3. Вывести список");
        System.out.println("4. Очистить список");
        System.out.println("5. Проверить список на пустоту");
        System.out.println("0. Выход");
        System.out.print("Выберите пункт: ");
    }
}
