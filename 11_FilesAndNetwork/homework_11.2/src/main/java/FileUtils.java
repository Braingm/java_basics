import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        Path source = Paths.get(sourceDirectory);
        Path destination = Paths.get(destinationDirectory);
        Set <Path> files = new HashSet<>();

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
                if (destinationFile.toFile().exists()){
                    if (destinationFile.toFile().getUsableSpace() == file.toFile().getUsableSpace())
                    files.add(file);
                    return FileVisitResult.CONTINUE;
                }
                Files.copy(file, destinationFile);
                return FileVisitResult.CONTINUE;
            }
        });

        if (!files.isEmpty()){
            System.out.println("Данные файлы уже существуют:\n");
            files.forEach(System.out::println);
            System.out.println("Заменить? y/n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String answer = reader.readLine();
            if (answer.matches("y(es)?")){
                files.forEach((Path file) -> {
                    Path destinationFile = destination.resolve(source.relativize(file));
                    try {
                        Files.copy(file, destinationFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

    }
}
