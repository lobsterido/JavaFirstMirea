public class Task2 {
    public static void main(String[] args) {
        Person first = new Person("Лобасов", "Григорий", "Геннадьевич");
        Person second = new Person("Иванова", "Анна", null);
        Person third = new Person("Петров", "", "");
        Person fourth = new Person("Сидоров", "Максим", "Олегович");

        System.out.println(first.getShortName());
        System.out.println(second.getShortName());
        System.out.println(third.getShortName());
        System.out.println(fourth.getShortName());
    }
}
