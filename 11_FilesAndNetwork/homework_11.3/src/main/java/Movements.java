import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Movements {
    public static List<Movement> movements = new ArrayList<>();

    public Movements(String pathMovementsCsv) {
    }

    public double getExpenseSum() {
        Set<Double> sumSet = new HashSet();
        movements.forEach(movement -> sumSet.add(movement.getOutcome().doubleValue()));
        return sumSet.stream().reduce(Double::sum).get();
    }

    public double getIncomeSum() {
        return 0.0;
    }
}
