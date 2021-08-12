
public class Main {
    public static final String filePath = "src/test/resources/movementList.csv";

    public static void main(String[] args) {
        var var1 = new Movements(filePath);
        System.out.println(var1.getIncomeSum());
        System.out.println(var1.getExpenseSum());
        System.out.println(var1.getPlaces());
    }
}
