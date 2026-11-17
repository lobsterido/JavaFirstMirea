public class MergeStudents {
    public static void main(String[] args) {
        Student[] firstList = {
                new Student("Мария", "Кузнецова", "Информационные системы", 3, "ИС-31", 4.9),
                new Student("Анна", "Иванова", "Прикладная информатика", 2, "ПИ-21", 4.6),
                new Student("Ольга", "Попова", "Программная инженерия", 1, "ПИ-12", 4.4)
        };

        Student[] secondList = {
                new Student("Григорий", "Лобасов", "Информационные системы", 3, "ИС-32", 5.0),
                new Student("Пётр", "Смирнов", "Программная инженерия", 1, "ПИ-11", 4.1),
                new Student("Иван", "Соколов", "Прикладная информатика", 2, "ПИ-22", 3.8)
        };

        System.out.println("Первый список (отсортирован по баллу):");
        print(firstList);

        System.out.println("Второй список (отсортирован по баллу):");
        print(secondList);

        Student[] merged = mergeLists(firstList, secondList);

        System.out.println("Объединённый отсортированный список:");
        print(merged);
    }

    public static Student[] mergeLists(Student[] first, Student[] second) {
        Student[] result = new Student[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i].getGpa() >= second[j].getGpa()) {
                result[k++] = first[i++];
            } else {
                result[k++] = second[j++];
            }
        }
        while (i < first.length) {
            result[k++] = first[i++];
        }
        while (j < second.length) {
            result[k++] = second[j++];
        }
        return result;
    }

    public static void print(Student[] students) {
        System.out.println("Фамилия      Имя        Специальность          Курс   Группа   Балл");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
