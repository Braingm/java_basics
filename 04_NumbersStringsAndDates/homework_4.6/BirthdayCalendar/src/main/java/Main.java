import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern(" - dd.MM.yyyy - EEE", Locale.US);
        LocalDate currentDate = LocalDate.now();
        LocalDate inputDate = LocalDate.of(year, month, day);

        StringBuilder result = new StringBuilder();

        for (int i = 0; currentDate.isAfter(inputDate) || currentDate.isEqual(inputDate); i++) {
            result.append(i + format.format(inputDate) + System.lineSeparator());
            inputDate = inputDate.plusYears(1);
        }

        return result.toString();
    }
}
