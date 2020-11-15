public class Cat {
    private double originWeight;
    private final double minWeight;
    private final double maxWeight;
    private double weight;
    private double feedEaten;

    private final int EYES_COUNT = 2;
    public static int count = 0;
    private furColors furColor;
    private boolean isDead = false;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000;
        maxWeight = 9000;
        count++;

    }

    public Cat(double weight) {
        this();
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
        if (weight < minWeight) {
            if (!isDead) {
                isDead = true;
                count--;
            }
            return "Dead";
        } else if (weight > maxWeight) {
            if (!isDead) {
                isDead = true;
                count--;
            }
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

    public furColors getFurColor() {
        return furColor;
    }

    public void setFurColor(furColors furColor) {
        this.furColor = furColor;
    }
}