import lombok.Getter;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Movement {
    private String type;
    private String number;
    @Getter
    private String currency;
    private Date date;
    private String UUID;
    @Getter
    private String details;
    @Getter
    private BigDecimal income;
    @Getter
    private BigDecimal outcome;

    private Movement() {
    }

    @SneakyThrows
    public static Movement parseMovement(String[] args) {
        if (args.length != 8)
            throw new IllegalArgumentException("Неверный формат записи");
        var movement = new Movement();
        movement.type = args[0];
        movement.number = args[1];
        movement.currency = args[2];
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        movement.date = format.parse(args[3]);
        movement.UUID = args[4];
        movement.details = args[5];
        movement.income = BigDecimal.valueOf(validate(args[6]));
        movement.outcome = BigDecimal.valueOf(validate(args[7]));

        return movement;
    }

    private static double validate(String input) {
        StringBuilder builder = new StringBuilder();

        if (input.matches("\"\\d+,\\d+\"")) {
            input = input.replace(',', '.');
            builder.append(input, 1, input.length() - 1);
        } else {
            input = input.replace(',', '.');
            builder.append(input);
        }

        return Double.parseDouble(builder.toString());
    }
}
