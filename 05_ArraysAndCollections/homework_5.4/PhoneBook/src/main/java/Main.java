import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String WRONG_INPUT = "Неверный формат ввода";
    private static final String SUCCESS = "Контакт сохранен!";
    private static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                for (String contact : phoneBook.getAllContacts()) {
                    System.out.println(contact);
                }
            } else if (input.matches("\\W+[^\\d+]")) {
                if (!phoneBook.containsName(input))
                    System.out.println("Такого имени в телефонной книге нет.");
                System.out.printf("Введите номер телефона для абонента \"%s\" :", input);
                String number = reader.readLine();
                phoneBook.addContact(number, input);
                System.out.println(SUCCESS);
            } else if (input.matches("\\d{11}")) {
                if (!phoneBook.containsNumber(input))
                    System.out.println("Такого номера нет в телефонной книге.");
                System.out.printf("Введите имя абонента для номера \"%s\":", input);
                String name = reader.readLine();
                phoneBook.addContact(input, name);
                System.out.println(SUCCESS);
            } else
                System.out.println(WRONG_INPUT);

        }
    }
}
