import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Movements {
    public List<Movement> movements = new ArrayList<>();

    public Movements(String pathMovementsCsv) {
        Path path = Paths.get(pathMovementsCsv);
        try {
            Files.lines(path).skip(1).forEach(str -> movements.add(Movement.parseMovement(str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {
        BigDecimal result = new BigDecimal(0);
        return movements.stream().map(Movement::getOutcome).reduce(result, BigDecimal::add).doubleValue();
    }

    public double getIncomeSum() {
        BigDecimal result = new BigDecimal(0);
        return movements.stream().map(Movement::getIncome).reduce(result, BigDecimal::add).doubleValue();
    }

    public String getPlaces() {
        StringBuilder result = new StringBuilder();
        movements.stream().filter(movement -> movement.getOutcome().doubleValue() > 0)
                .forEach(movement -> result.append(movement.getDetails().split("\\s{4,}")[1])
                        .append("\t\t")
                        .append(movement.getOutcome())
                        .append(" ")
                        .append(movement.getCurrency())
                        .append(System.lineSeparator()));
        return result.toString();

    }
}
