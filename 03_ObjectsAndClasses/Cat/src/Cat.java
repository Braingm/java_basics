public class Cat {
    private final double originWeight;
    private double weight;
    private double feedEaten;

    private final double MIN_WEIGHT = 1000;
    private final double MAX_WEIGHT = 9000;
    private final int EYES_COUNT = 2;
    public static int count = 0;
    private String furColor;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;

    }
    public Cat(double weight){
        this.weight = weight;
        originWeight = weight;
        count++;
    }

    public void meow() {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount) {
        weight = weight + amount;
        feedEaten += amount;
    }

    public void drink(Double amount) {
        weight = weight + amount;
        feedEaten += amount;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            count--;
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            count--;
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public static int getCount() {
        return count;
    }

    public double getEatenAmount() {
        return feedEaten;
    }

    public void pee() {
        weight -= 50;
        System.out.println("Очищение биологических отходов. Инициализация...");
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
}