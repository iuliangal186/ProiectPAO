package service;

import java.io.IOException;
import java.nio.file.*;

public class FilesService {
    public void createFolder(String folderName) throws IOException{
        Path path = Paths.get(folderName);
        Files.createDirectories(path);
    }

    public void createFile(String fileName) throws IOException{
        Path path = Paths.get(fileName);
        Files.createFile(path);
    }

    public void deleteFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.deleteIfExists(path);
    }

    public void listFolder(String folderName) throws IOException {
        Path path = Paths.get(folderName);
        Files.list(path).forEach(p -> System.out.println(p));
    }
}
