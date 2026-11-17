public class DoublyLinkedList {
    private static class Node {
        private final Card data;
        private Node next;
        private Node previous;

        private Node(Card data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Card card) {
        Node newNode = new Node(card);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(int index) {
        if (index < 1 || index > size) {
            return false;
        }
        Node current = nodeAt(index);
        if (current.previous == null) {
            head = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current.next == null) {
            tail = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        size--;
        return true;
    }

    private Node nodeAt(int index) {
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.printf("%-4s %-32s %-10s %s%n", "№", "ФИО", "Группа", "Балл");
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.printf("%-4d ", index);
            current.data.print();
            current = current.next;
            index++;
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.println("Список в обратном порядке:");
        System.out.printf("%-4s %-32s %-10s %s%n", "№", "ФИО", "Группа", "Балл");
        Node current = tail;
        int index = size;
        while (current != null) {
            System.out.printf("%-4d ", index);
            current.data.print();
            current = current.previous;
            index--;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
