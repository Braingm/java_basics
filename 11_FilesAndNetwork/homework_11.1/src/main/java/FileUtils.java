import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {
    private static final Logger LOGGER = LogManager.getLogger(FileUtils.class);

    public static long calculateFolderSize(String path) {
        Path directoryPath = Paths.get(path);
        long size = 0;
        try (Stream<Path> walk = Files.walk(directoryPath)) {
            size = walk
                    .filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        try {
                            return Files.size(p);
                        } catch (IOException e) {
                            LOGGER.error(e);
                            System.out.printf("Невозможно получить размер файла %s%n%s", p, e);
                            return 0L;
                        }
                    })
                    .sum();
        } catch (IOException e) {
            LOGGER.error(e);
            System.out.printf("Ошибка при подсчёте размера директории %s", e);
        }
        return size;
    }
}
