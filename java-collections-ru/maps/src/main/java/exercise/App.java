package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordsMap = new HashMap<>();
        String[] words = sentence.split(" ");
        if (sentence.equals("")) {
            return wordsMap;
        }
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        return wordsMap;
    }

    public static String toString(Map<String, Integer> words) {
        if (words.isEmpty()) {
            return "{}";
        }
        String result = "{\n";
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            result = result + "  " + word.getKey() + ": " + word.getValue() + "\n";
        }
        result = result + "}";
        return result;
    }
}
//END
