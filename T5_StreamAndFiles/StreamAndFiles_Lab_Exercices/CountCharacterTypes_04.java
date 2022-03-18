package JavaAdvanced.StreamAndFilesExercices;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Admin\\Desktop\\Java Advanced\\Exercises Resources\\input.txt";
        List<String> lines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("CharacterCount.output.txt");

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        for (String line :lines) {
            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (symbol == ' '){
                    continue;
                }
                if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u'){
                    vowels++;
                }else if (symbol == '!' || symbol == '?' || symbol == '.' || symbol == ','){
                    punctuation++;
                }else {
                    consonants++;
                }
            }
        }
        writer.write("Vowels: " + vowels);
        writer.println();
        writer.write("Consonants: " + consonants);
        writer.println();
        writer.write("Punctuation: " + punctuation);
        writer.close();
    }
}
