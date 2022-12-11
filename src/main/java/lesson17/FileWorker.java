package lesson17;

import lesson16.Person;
import lesson16.Sex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileWorker {
    private static final String PATH_TO_DIR = "src/main/java/lesson17/output";
    public static final String PATH_TO_FILE = PATH_TO_DIR + "/result.csv";
    public static final String IMAGE_URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFtIiwbQLKvRRQn_06612_CSC84SsKQTbvoQ&usqp=CAU";

    public void createEmptyDirectory() {
        Path output = Paths.get(PATH_TO_DIR);
        try {
            Files.createDirectories(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createFile() {
        Path result = Paths.get(PATH_TO_FILE);
        try {
            if (Files.exists(result)) return;
            Files.createFile(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateFile() {
        List<String> people = Stream.of(
                new Person("Вася", 16, Sex.MAN),
                new Person("Петя", 23, Sex.MAN),
                new Person("Олена", 42, Sex.WOMAN),
                new Person("Іван Іванович", 69, Sex.MAN)
        ).map(Person::toCSVFormat).toList();

        Path result = Paths.get(PATH_TO_FILE);
        try {
            Files.write(result, people);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadImage() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("output.jpg")) {
            ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(IMAGE_URL).openStream());
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
