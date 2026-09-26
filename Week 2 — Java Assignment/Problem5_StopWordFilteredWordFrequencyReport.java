import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem5_StopWordFilteredWordFrequencyReport {
    static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>(
                Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "")
                .replace("\"", "")
                .replace("'", "");

        String trimmed = cleaned.trim();
        if (trimmed.isEmpty()) {
            return;
        }

        String[] words = trimmed.split("\\s+");
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency(
                "The mentor was great, the session was great and clear.");
    }
}
