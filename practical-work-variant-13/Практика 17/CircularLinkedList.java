public class CircularLinkedList {
    private static class Node {
        private final Card data;
        private Node next;

        private Node(Card data) {
            this.data = data;
        }
    }

    private Node tail;
    private int size;

    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    public void add(Card card) {
        Node newNode = new Node(card);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(int index) {
        if (index < 1 || index > size) {
            return false;
        }
        Node previous = tail;
        for (int i = 1; i < index; i++) {
            previous = previous.next;
        }
        Node current = previous.next;
        if (size == 1) {
            tail = null;
        } else {
            previous.next = current.next;
            if (current == tail) {
                tail = previous;
            }
        }
        size--;
        return true;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.printf("%-4s %-32s %-10s %s%n", "№", "ФИО", "Группа", "Балл");
        Node start = tail.next;
        Node current = start;
        int index = 1;
        do {
            System.out.printf("%-4d ", index);
            current.data.print();
            current = current.next;
            index++;
        } while (current != start);
    }

    public void clear() {
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public int size() {
        return size;
    }
}
