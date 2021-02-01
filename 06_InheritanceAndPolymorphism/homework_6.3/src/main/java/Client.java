public abstract class Client {
    protected double moneyAmount = 0;

    public double getAmount() {
        return moneyAmount;
    }

    public void put(double amountToPut) {
        if (amountToPut <= 0){
            return;
        }
        moneyAmount += amountToPut;
    }

    public void take(double amountToTake) {
        if (amountToTake > moneyAmount || amountToTake <= 0){
            return;
        }
        moneyAmount -= amountToTake;
    }

}
