import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            if (!isValid(input)) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }

            String[] names = input.split(" ");
            System.out.printf("Фамилия: %s\r\nИмя: %s\r\nОтчество: %s", names[0], names[1], names[2]);

        }
    }

    private static boolean isValid(String str) {
        int result = 0;
        Matcher matcher = Pattern.compile("[\\s\\d]").matcher(str);
        while (matcher.find())
            result++;
        return result == 2;
    }

}