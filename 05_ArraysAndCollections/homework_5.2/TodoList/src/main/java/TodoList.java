import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<String> list = new ArrayList<>();

    public void add(String todo) {
        list.add(list.size(), todo);
        System.out.printf("Добавлено дело \"%s\"", todo);
    }

    public void add(int index, String todo) {
        if (index > list.size() + 1) {
            System.out.println("Неверный индекс");
            return;
        }
        if (index == list.size() + 1)
            list.add(index - 1, todo.trim());
        else
            list.add(index, todo.trim());
        System.out.printf("Добавлено дело \"%s\" на позицию %d", todo.trim(), index);
    }

    public void edit(String todo, int index) {
        if (index > list.size() - 1) {
            System.out.println("Изменение не возможно, неверный индекс");
            return;
        }
        System.out.printf("Дело \"%s\" заменено на \"%s\"", list.get(index), todo.trim());
        list.set(index, todo.trim());
    }

    public void delete(int index) {
        if (index > list.size() - 1) {
            System.out.println("Неверный индекс");
            return;
        }
        System.out.printf("Дело \"%s\" удалено", list.get(index));
        list.remove(index);
    }

    public void list() {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d - %s", i, list.get(i) + System.lineSeparator());
        }
    }

    public ArrayList<String> getTodos() {
        return (ArrayList<String>) list;
    }
}