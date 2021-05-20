import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        Path source = Paths.get(sourceDirectory);
        Path destination = Paths.get(destinationDirectory);

        Files.walkFileTree(source, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attrs) throws IOException {
                Path destinationSubDir = destination.resolve(source.relativize(directory));
                Files.createDirectories(destinationSubDir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path destinationFile = destination.resolve(source.relativize(file));
                Files.copy(file, destinationFile);
                return FileVisitResult.CONTINUE;
            }
        });

    }
}
