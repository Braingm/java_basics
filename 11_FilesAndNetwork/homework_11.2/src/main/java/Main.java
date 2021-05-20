import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String source = null;
        String destination = null;

        try {
            System.out.println("Введите папку для копирования");
            source = reader.readLine();
            System.out.println("Введите папку назначения");
            destination = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileUtils.copyFolder(source,destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
