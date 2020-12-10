import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        DateFormat format = new SimpleDateFormat(" - dd.MM.yyyy - EEE", Locale.US);
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

            calendar.set(year, month - 1, day);
        Date inputDate = calendar.getTime();

        StringBuilder result = new StringBuilder();

        for (int i = 0; currentDate.after(inputDate) || currentDate.equals(inputDate); i++) {
            result.append(i + format.format(inputDate) + System.lineSeparator());
            calendar.add(Calendar.YEAR, 1);
            inputDate = calendar.getTime();
        }

        return result.toString();
    }
}
