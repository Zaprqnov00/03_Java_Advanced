package JavaAdvanced.StreamAndFilesExercices;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {

        String wordsPath = "C:\\Users\\Admin\\Desktop\\Java Advanced\\Exercises Resources\\words.txt";
        List<String> lines = Files.readAllLines(Path.of(wordsPath));

        Map<String,Integer> mapWithWords = new LinkedHashMap<>();
        for (String line :lines) {
            String[] word = line.split(" ");
            for (int i = 0; i < word.length; i++) {
                mapWithWords.put(word[i],0);
            }
        }

        String textInput = "C:\\Users\\Admin\\Desktop\\Java Advanced\\Exercises Resources\\text.txt";
        List<String> textWords = Files.readAllLines(Path.of(textInput));

        for (String line :textWords) {
            String[] searchWord = line.split(" ");
            for (int i = 0; i < searchWord.length; i++) {
                String currentWord = searchWord[i];
                if (mapWithWords.containsKey(currentWord)){
                    mapWithWords.put(currentWord,mapWithWords.get(currentWord) + 1);
                }
            }
        }

        PrintWriter writer = new PrintWriter("SearchWord.output.txt");

        mapWithWords.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    writer.println(entry.getKey() + " - " + entry.getValue());
                });
        writer.close();
    }
}
