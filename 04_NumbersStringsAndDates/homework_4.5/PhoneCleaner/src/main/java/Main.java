import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            StringBuilder result = new StringBuilder();
            result.append(input.replaceAll("[^0-9]", ""));

            if (result.length() < 10 || result.length() > 11) {
                System.out.println("Неверный формат номера");
                break;
            }

            if (result.length() == 10)
                result.insert(0, 7);

            if (result.substring(0, 1).equals("8"))
                result.replace(0, 1, "7");

            if (!result.substring(0, 1).equals("7")) {
                System.out.println("Неверный формат номера");
                break;
            }

            System.out.println(result);
        }
    }

}
