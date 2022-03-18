package JavaAdvanced.StreamAndFilesExercices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class SumLine_01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Admin\\Desktop\\Java Advanced\\Exercises Resources\\input.txt";
        List<String> lines = Files.readAllLines(Path.of(path));

        for (String line :lines) {
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                sum += symbol;
            }
            System.out.println(sum);
        }

    }
}
