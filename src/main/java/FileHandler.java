import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public static void saveToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(content + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        // Implement logic to read from the file and return content as a String
        return null;
    }
}
