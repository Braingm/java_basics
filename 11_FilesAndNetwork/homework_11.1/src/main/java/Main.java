import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //Инициализация листа
    private static final List<String> memoryUnits = new ArrayList();
    public static Logger logger = LogManager.getRootLogger();

    static {
        memoryUnits.add("Б");
        memoryUnits.add("Кб");
        memoryUnits.add("Гб");
        memoryUnits.add("Тб");
    }

    public static void main(String[] args) {
        while (true) {
            var reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите путь к папке:");
            String path = "";
            try {
                path = reader.readLine();
            } catch (IOException e) {
                logger.error(e);
                System.out.println("Ошибка ввода");
                continue;  //При возникновении ошибки начинает цикл сначала. Гарантирует инициализацию path
            }
            File directory = new File(path);
            if (!directory.isDirectory()) {
                System.out.println("Введён путь к файлу");
            }
            if (!directory.exists()) {
                System.out.println("Папка не существует");
            }

            double folderSize = (double) FileUtils.calculateFolderSize(path);
            int unitOrder = 0;
            while (folderSize > 1024.0) {
                folderSize /= 1024.0;
                unitOrder++;
            }
            if (folderSize >= 1000.0) {
                unitOrder++;
                folderSize /= 1000.0;
            }

            try {
                System.out.printf("Размер папки %s составляет %s %s%n", path, new DecimalFormat("0.0").format(folderSize), memoryUnits.get(unitOrder));
            } catch (Exception e) {
                System.out.println("Произошла ошибка");
                logger.error(e);
            }
        }
    }
}
