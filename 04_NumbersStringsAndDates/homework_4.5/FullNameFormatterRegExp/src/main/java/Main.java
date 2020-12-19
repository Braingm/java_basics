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
            if (!input.matches("([А-Я][а-я]+(-[А-Я][а-я]*)?\\s?){3}[а-я]*")) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }
            StringBuilder result = new StringBuilder();
            String[] names = new String[3];
            int i = 0;

            Matcher matcher = Pattern.compile("([А-Я][а-я]+(-?[А-Я][а-я]+)?)(\\s?[а-я]+)?").matcher(input);
            while (matcher.find()) {
                names[i] = matcher.group();
                i++;
            }
            System.out.printf("Фамилия: %s\r\nИмя: %s\r\nОтчество: %s", names[0], names[1], names[2]);
        }
    }
}