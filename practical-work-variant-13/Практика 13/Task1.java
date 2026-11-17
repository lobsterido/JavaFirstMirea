public class Task1 {
    public static void main(String[] args) {
        String text = "I like Java!!!";

        System.out.println("Строка: " + text);
        System.out.println("Последний символ: " + lastCharacter(text));
        System.out.println("Заканчивается на \"!!!\": " + text.endsWith("!!!"));
        System.out.println("Начинается на \"I like\": " + text.startsWith("I like"));
        System.out.println("Содержит \"Java\": " + text.contains("Java"));
        System.out.println("Позиция \"Java\": " + text.indexOf("Java"));
        System.out.println("Замена \"a\" на \"o\": " + text.replace('a', 'o'));
        System.out.println("Верхний регистр: " + text.toUpperCase());
        System.out.println("Нижний регистр: " + text.toLowerCase());
        System.out.println("Без слова \"Java\": " + removeWord(text, "Java"));
    }

    public static char lastCharacter(String text) {
        return text.charAt(text.length() - 1);
    }

    public static String removeWord(String text, String word) {
        int index = text.indexOf(word);
        if (index < 0) {
            return text;
        }
        return text.substring(0, index) + text.substring(index + word.length());
    }
}
