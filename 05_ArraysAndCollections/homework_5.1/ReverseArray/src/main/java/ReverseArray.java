public class ReverseArray {

    public static String[] reverse(String[] strings) {
        // Конечная позиция
        int z = strings.length - 1;
        // Пузырь
        String str;

        for (int i = 0; i < strings.length / 2; i++) {
            str = strings[i];
            strings[i] = strings[z];
            strings[z--] = str;
        }
        return strings;
    }
}
