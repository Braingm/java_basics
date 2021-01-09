import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static final String LIST = "list";
    public static final String ADD = "add";
    public static EmailList emailList = new EmailList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            String[] inputParts = input.split(" ", 2);
            switch (inputParts[0].toLowerCase()) {
                case LIST -> {
                    for (String s : emailList.getSortedEmails()) {
                        System.out.println(s);
                    }
                }
                case ADD -> {
                    if (inputParts[1].matches(".+@.+\\.+.+")) {
                        emailList.add(inputParts[1]);
                        System.out.println("Added");
                    } else {
                        System.out.println(WRONG_EMAIL_ANSWER);
                    }
                }
            }
        }
    }
}
