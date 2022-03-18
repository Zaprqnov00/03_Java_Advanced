package JavaAdvanced.StreamAndFilesExercices;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals_03 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Admin\\Desktop\\Java Advanced\\Exercises Resources\\input.txt";
        List<String> lines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("CapitalLetters.output.txt");

        for (String line :lines) {
            writer.println(line.toUpperCase());
        }
        writer.close();
    }
}
