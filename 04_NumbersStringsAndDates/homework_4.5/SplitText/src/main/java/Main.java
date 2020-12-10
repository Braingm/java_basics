public class Main {

    public static void main(String[] args) {

    }

    public static String splitTextInToWords(String text) {
        String[] buffer = text.replaceAll("[^a-zA-Z-’\\s]+", "").split("[\\s-]+");
        StringBuilder result = new StringBuilder();


        if (text.length() > 0) {
            for (String str : buffer)
                result.append(str).append(System.lineSeparator());
            result.delete(result.length() - 1, result.length());
        }

        return result.toString();
    }

}