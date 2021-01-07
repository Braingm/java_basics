import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = reader.readLine();
            if (string.equalsIgnoreCase("exit"))
                break;

            String[] command = string.split(" ", 2);

            int index;
            boolean mark;
            try {
                index = Integer.parseInt(command[1].substring(0, command[1].indexOf(" ")));
                mark = true;
            } catch (Exception e) {
                index = -1;
                mark = false;
            }

            switch (command[0].toLowerCase()) {
                case "list" -> todoList.list();
                case "delete" -> todoList.delete(Integer.parseInt(command[1]));
                case "add" -> {
                    if (mark)
                        todoList.add(index, command[1].substring(command[1].indexOf(" ")));
                    else
                        todoList.add(command[1]);
                }
                case "edit" -> todoList.edit(command[1].substring(command[1].indexOf(" ")), index);
            }
        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}
