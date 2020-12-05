public class Main {

    public static void main(String[] args) {
        char[] latinAlphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".toCharArray();
        for (char c : latinAlphabet) {
            System.out.println("Буква : " + c);
            System.out.println("Код : " + (int) c + "\n");
        }
    }
}
