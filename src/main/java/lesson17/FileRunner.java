package lesson17;

import lesson16.Person;
import lesson16.Sex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileRunner {
    public static void main(String[] args) {
        FileWorker fileWorker = new FileWorker();
        fileWorker.createEmptyDirectory();
        fileWorker.createFile();
        fileWorker.populateFile();

        fileWorker.loadImage();
    }
}
