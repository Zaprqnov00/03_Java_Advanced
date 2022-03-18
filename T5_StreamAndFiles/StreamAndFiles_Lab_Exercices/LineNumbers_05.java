package JavaAdvanced.StreamAndFilesExercices;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Admin\\Desktop\\Java Advanced\\Exercises Resources\\inputLineNumbers.txt";
        List<String> lines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("lines.output.txt");
        AtomicInteger count = new AtomicInteger();
        count.set(1);
        for (String line :lines) {
            writer.write(count.getAndIncrement() + ". " + line);
            writer.println();
        }
        writer.close();
    }
}
