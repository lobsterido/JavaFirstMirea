public class SinglyLinkedList {
    private static class Node {
        private final Card data;
        private Node next;

        private Node(Card data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Card card) {
        Node newNode = new Node(card);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean remove(int index) {
        if (index < 1 || index > size) {
            return false;
        }
        if (index == 1) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 1; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
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
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.printf("%-4d ", index);
            current.data.print();
            current = current.next;
            index++;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
