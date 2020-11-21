public class Cat {
    private double originWeight;
    private final double MIN_WEIGHT = 1000;
    private final double MAX_WEIGHT = 9000;
    private double weight;
    private double feedEaten;

    private double minWeight;
    private double maxWeight;

    private final int EYES_COUNT = 2;
    public static int count = 0;
    private FurColors furColor;
    private boolean isDead = false;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = MIN_WEIGHT;
        maxWeight = MAX_WEIGHT;
        count++;

    }

    public Cat(double weight) {
        this();
        this.weight = weight;
        originWeight = weight;
        count++;
    }

    public void meow() {
        if (isDead) {
            System.out.println("Котейка умерла :(");
            return;
        }
        weight = weight - 1;
        System.out.println("Meow");
        this.lifeCheck();
    }

    public void feed(Double amount) {
        if (isDead) {
            System.out.println("Котейка умерла :(");
            return;
        }
        weight = weight + amount;
        feedEaten += amount;
        this.lifeCheck();
    }

    public void drink(Double amount) {
        if (isDead) {
            System.out.println("Котейка умерла :(");
            return;
        }
        weight = weight + amount;
        feedEaten += amount;
        this.lifeCheck();
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public void lifeCheck() {
        if (weight > maxWeight || weight < minWeight) {
            if (!isDead) {
                isDead = true;
                count--;
            }
        }
    }

    public static int getCount() {
        return count;
    }

    public double getEatenAmount() {
        return feedEaten;
    }

    public void pee() {
        if (isDead) {
            System.out.println("Котейка умерла :(");
            return;
        }
        weight -= 50;
        System.out.println("Очищение биологических отходов. Инициализация...");
        this.lifeCheck();
    }

    public FurColors getFurColor() {
        return furColor;
    }

    public void setFurColor(FurColors furColor) {
        this.furColor = furColor;
    }
}