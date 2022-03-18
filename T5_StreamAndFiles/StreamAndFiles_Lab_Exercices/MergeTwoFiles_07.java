package JavaAdvanced.StreamAndFilesExercices;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles_07 {
    public static void main(String[] args) throws IOException {

        String firstFile = "C:\\Users\\Admin\\Desktop\\Java Advanced\\Exercises Resources\\inputOne.txt";
        String secondFile = "C:\\Users\\Admin\\Desktop\\Java Advanced\\Exercises Resources\\inputTwo.txt";
        List<String> compileFirst = Files.readAllLines(Path.of(firstFile));
        List<String> compileSecond= Files.readAllLines(Path.of(secondFile));

        PrintWriter writer = new PrintWriter("MergeTwoFiles.output.txt");
        for (String first :compileFirst) {
            String[] numbers = first.split(" ");
            for (int i = 0; i < numbers.length; i++) {
                writer.println(numbers[i]);
            }
        }
        for (String second :compileSecond) {
            String[] numbers = second.split(" ");
            for (int i = 0; i < numbers.length; i++) {
                writer.println(numbers[i]);
            }
        }
        writer.close();
    }
}
