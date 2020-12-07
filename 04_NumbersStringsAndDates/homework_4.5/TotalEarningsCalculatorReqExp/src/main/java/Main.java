import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

    }

    public static int calculateSalarySum(String text) {
        int result = 0;
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result += Integer.parseInt(matcher.group());
        }
        return result;
    }

}