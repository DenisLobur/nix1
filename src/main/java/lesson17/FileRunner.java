package lesson17;

public class FileRunner {
    public static void main(String[] args) {
        FileWorker fileWorker = new FileWorker();
        fileWorker.createEmptyDirectory();
        fileWorker.createFile();
        fileWorker.populateFile();

        fileWorker.loadImage();
    }
}
