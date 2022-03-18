package JavaAdvanced.StreamAndFilesExercices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Admin\\Desktop\\Java Advanced\\Exercises Resources\\input.txt";
        List<String> lines = Files.readAllLines(Path.of(path));

        long sum = 0;
        for (String line :lines) {

            for (int i = 0; i < line.length(); i++) {
                char symbols = line.charAt(i);
                sum += symbols;
            }
        }
        System.out.println(sum);
    }
}
