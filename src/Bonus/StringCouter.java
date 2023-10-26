package Bonus;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class StringCouter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci una parola: ");
        String word = scanner.nextLine();

        Map<Character, Integer> occurrenceMap = new HashMap<>();

        for (char c : word.toCharArray()) {
            // Ignora spazi vuoti
            if (Character.isWhitespace(c)) {
                continue;
            }

            occurrenceMap.put(c, occurrenceMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
