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
    private static final List<String> memoryUnits = new ArrayList<>();
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    //Инициализация листа
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
            String path;
            try {
                path = reader.readLine();
            } catch (IOException e) {
                LOGGER.error(e);
                System.out.println("Ошибка ввода");
                continue;  //При возникновении ошибки начинает цикл сначала. Гарантирует инициализацию path
            }

            //Выход из цикла
            if (path.equals("")) {
                break;
            }
            File directory = new File(path);

            if (!directory.isDirectory()) {
                System.out.println("Введён путь к файлу");
            }
            if (!directory.exists()) {
                System.out.println("Папка не существует");
            }

            //Определение подходящего размера
            double folderSize = (double) FileUtils.calculateFolderSize(path);
            int unitOrder = 0;
            while (folderSize > 1024.0) {
                folderSize /= 1024.0;
                unitOrder++;
            }
            //Дополнительное приведение к привычному для пользователя формата с минимальной потерей точности
            if (folderSize >= 1000.0) {
                unitOrder++;
                folderSize /= 1000.0;
            }

            try {
                System.out.printf("Размер папки %s составляет %s %s%n", path, new DecimalFormat("0.0").format(folderSize), memoryUnits.get(unitOrder));
            } catch (Exception e) {
                System.out.println("Произошла ошибка");
                LOGGER.error(e);
            }
        }
    }
}
