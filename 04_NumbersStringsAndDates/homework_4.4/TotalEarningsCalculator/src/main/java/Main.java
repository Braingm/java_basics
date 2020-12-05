public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        char[] chars = text.toCharArray();
        int result = 0;
        StringBuilder part = new StringBuilder();
        for (char c : chars) {
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
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