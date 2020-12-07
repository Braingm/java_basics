public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        char[] chars = text.toCharArray();
        int result = 0;
        StringBuilder part = new StringBuilder();
        for (char c : chars) {
            if (c >= 48 && c <= 57) {
                part.append(c);
            } else {
                if (!(part.toString().equals(""))) {
                    result += Integer.parseInt(part.toString());
                    part.delete(0, part.length());
                }
            }
        }
        System.out.println(result);
    }

}