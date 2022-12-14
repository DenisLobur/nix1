package lesson17;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FilesTest {

    private final FileWorker fileWorker = new FileWorker();

    @AfterAll
    void clean() {
        // uncomment if it is needed to delete image after all tests
        //fileWorker.clean();
    }

    @Test
    void checkIfFilesCreated() {
        fileWorker.createEmptyDirectory();
        fileWorker.createFile();

        Path outputDir = Paths.get(FileWorker.PATH_TO_DIR);
        assertTrue(Files.exists(outputDir));

        Path outputFile = Paths.get(FileWorker.PATH_TO_FILE);
        assertTrue(Files.exists(outputFile));
    }

    @Test
    void checkIfFilePopulated() {
        fileWorker.populateFile();
        Path outputFile = Paths.get(FileWorker.PATH_TO_FILE);

        try (Stream<String> lines = Files.lines(outputFile)) {
            List<String> fileEntries = lines.toList();
            assertEquals("Вася, 16, man", fileEntries.get(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void checkIfFileDownloaded() {
        fileWorker.loadImage();

        Path image = Paths.get(FileWorker.PATH_TO_IMAGE);
        assertTrue(Files.exists(image));
    }

    @Test
    void checkImageExtension() {
        Path image = Paths.get(FileWorker.PATH_TO_IMAGE);
        String fileName = image.toString();
        Stream<String> fileExtension = Stream.of(fileName).filter(file -> file.contains(".")).map(file -> file.substring(fileName.lastIndexOf(".") + 1));
        assertEquals("jpg", fileExtension.collect(Collectors.joining()));
    }
}
