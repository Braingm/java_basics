import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Movements {
    public List<Movement> movements = new ArrayList<>();

    public Movements(String pathMovementsCsv) {
        Path path = Paths.get(pathMovementsCsv);
        try {
            Files.lines(path).skip(1).forEach(str -> {
                movements.add(Movement.parseMovement(str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this.getIncomeSum());
    }

    public double getExpenseSum() {
        Set<Double> sumSet = new HashSet();
        movements.forEach(movement -> sumSet.add(movement.getOutcome().doubleValue()));
        return sumSet.stream().reduce(Double::sum).get();
    }

    public double getIncomeSum() {
        Set<Double> sumSet = new HashSet();
        movements.forEach(movement -> sumSet.add(movement.getIncome().doubleValue()));
        return sumSet.stream().reduce(Double::sum).get();
    }
}
