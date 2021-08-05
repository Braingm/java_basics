import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static final String filePath = "src/test/resources/movementList.csv";

    public static void main(String[] args) {
        Path path = Paths.get(filePath);
        try {
            Files.lines(path).skip(1).forEach(str -> {
                Movements.movements.add(Movement.parseMovement(str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        var test = new Movements(filePath);
        System.out.println(test.getExpenseSum());

    }
}
