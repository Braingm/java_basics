import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            if (containsNumbers(input)) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }
            if (!isValid(input)) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }

            int[] index = new int[5];
            index[0] = 0;
            for (int i = 0, j = 1; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    index[j] = i;
                    j++;
                    index[j] = i + 1;
                    j++;
                }
            }
            System.out.printf("Фамилия: %s\r\nИмя: %s\r\nОтчество: %s",
                    input.substring(index[0], index[1]), input.substring(index[2], index[3]), input.substring(index[4]));
        }
    }

    // Метод определяет, содержит ли строка число. Для большей читаемости
    private static boolean containsNumbers(String str) {
        if (str.contains("0"))
            return true;
        if (str.contains("1"))
            return true;
        if (str.contains("2"))
            return true;
        if (str.contains("3"))
            return true;
        if (str.contains("4"))
            return true;
        if (str.contains("5"))
            return true;
        if (str.contains("6"))
            return true;
        if (str.contains("7"))
            return true;
        if (str.contains("8"))
            return true;
        return str.contains("9");
    }

    // Метод проверяет валидность введённой строки
    private static boolean isValid(String str) {
        byte counter = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ')
                counter++;
        }
        return counter == 2;
    }
}