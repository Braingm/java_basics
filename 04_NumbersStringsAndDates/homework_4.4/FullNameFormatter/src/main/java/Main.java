import java.util.Scanner;

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

    // Метод проверяет валидность введённой строки
    private static boolean isValid(String str) {
        byte counter = 0;
        for (char c : str.toCharArray()) {
            if (c >= 48 && c <= 57)
                return false;
            if (c == ' ')
                counter++;
        }
        return counter == 2;
    }
}