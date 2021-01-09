import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String LIST = "list";
    private static final String DELETE = "delete";
    private static final String ADD = "add";
    private static final String EDIT = "edit";

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = reader.readLine();
            if (string.equalsIgnoreCase("exit"))
                break;

            String[] inputParts = string.split(" ", 2);
            String partWOIndex = null;

            int index = -1;
            boolean mark = false;
            try {
                index = Integer.parseInt(inputParts[1].substring(0, inputParts[1].indexOf(" ")));
                mark = true;
                partWOIndex = inputParts[1].substring(inputParts[1].indexOf(" "));
            } catch (Exception e) {}

            switch (inputParts[0].toLowerCase()) {
                case LIST -> todoList.list();
                case DELETE -> todoList.delete(index);
                case ADD -> {
                    if (mark)
                        todoList.add(index, partWOIndex);
                    else
                        todoList.add(inputParts[1]);
                }
                case EDIT -> todoList.edit(partWOIndex, index);
            }
        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}
