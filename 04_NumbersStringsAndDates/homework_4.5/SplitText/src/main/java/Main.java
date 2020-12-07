public class Main {

    public static void main(String[] args) {

    }

    public static String splitTextInToWords(String text) {
        String[] buffer = text.replaceAll("[^a-zA-Z-’\\s]+", "").split("[\\s-]");
        StringBuilder result = new StringBuilder();

        for (String str : buffer)
            if (!str.equals(""))
                result.append(str + "\r\n");
            if (result.length() > 0)
            result.delete(result.length()-1,result.length());

        return result.toString();
    }

}