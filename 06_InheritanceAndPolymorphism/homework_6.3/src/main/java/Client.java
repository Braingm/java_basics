public abstract class Client {
    protected double moneyAmount = 0;
    protected double takeTaxPercent = 0;
    protected double putTaxPercent = 0;

    public double getAmount() {
        return moneyAmount;
    }

    public void put(double amountToPut) {
        if (amountToPut <= 0) {
            return;
        }
        moneyAmount += amountToPut;
    }

    public void put(double amountToPut, double taxPercent) {
        if (amountToPut <= 0) {
            return;
        }
        double tax = amountToPut * (taxPercent / 100.0);
        moneyAmount += amountToPut - tax;
    }

    public void take(double amountToTake) {
        if (amountToTake > moneyAmount || amountToTake <= 0) {
            return;
        }
        moneyAmount -= amountToTake;
    }

    public void take(double amountToTake, double taxPercent) {
        double tax = amountToTake * (taxPercent / 100.0);
        if (amountToTake + tax > moneyAmount || amountToTake == 0) {
            return;
        }
        moneyAmount -= amountToTake + tax;
    }
}
