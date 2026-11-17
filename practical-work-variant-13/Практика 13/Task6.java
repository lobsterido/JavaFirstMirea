import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine().trim();

        String text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        List<String> words = new ArrayList<>();
        for (String word : text.split("\\s+")) {
            if (!word.isEmpty()) {
                words.add(word);
            }
        }

        System.out.println(getLine(words));
    }

    public static String getLine(List<String> words) {
        if (words.isEmpty()) {
            return "";
        }
        boolean[] used = new boolean[words.size()];
        StringBuilder chain = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            used[i] = true;
            chain.append(words.get(i));
            if (buildChain(words, used, chain, 1, i)) {
                return chain.toString();
            }
            chain.setLength(0);
            used[i] = false;
        }
        return "Невозможно составить цепочку";
    }

    private static boolean buildChain(List<String> words, boolean[] used,
                                      StringBuilder chain, int length, int lastIndex) {
        if (length == words.size()) {
            return true;
        }
        char lastCharacter = Character.toLowerCase(
                words.get(lastIndex).charAt(words.get(lastIndex).length() - 1));
        for (int i = 0; i < words.size(); i++) {
            if (!used[i] && Character.toLowerCase(words.get(i).charAt(0)) == lastCharacter) {
                used[i] = true;
                int oldLength = chain.length();
                chain.append(' ').append(words.get(i));
                if (buildChain(words, used, chain, length + 1, i)) {
                    return true;
                }
                chain.setLength(oldLength);
                used[i] = false;
            }
        }
        return false;
    }
}
