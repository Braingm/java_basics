import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String LIST = "list";
    private static final String DELETE = "delete";
    private static final String ADD = "add";
    private static final String EDIT = "edit";
    private static boolean mark = false;

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = reader.readLine();
            if (string.equalsIgnoreCase("exit"))
                break;

            String[] inputParts = string.split(" ", 3);

            int index = parseIndex(inputParts[2]);

            switch (inputParts[0].toLowerCase()) {
                case LIST -> todoList.list();
                case DELETE -> todoList.delete(index);
                case ADD -> {
                    if (mark)
                        todoList.add(index, inputParts[2]);
                    else
                        todoList.add(inputParts[1] + inputParts[2]);
                }
                case EDIT -> todoList.edit(inputParts[2], index);
            }
        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }

    private static int parseIndex(String input) {
        try {
            int index = Integer.parseInt(input);
            mark = true;
            return index;
        } catch (NumberFormatException e) {
            mark = false;
        }
        return -1;
    }
}
