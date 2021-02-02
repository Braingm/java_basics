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
        moneyAmount += amountToPut - getPutTax(amountToPut);
    }

    public void take(double amountToTake) {
        if (amountToTake + getTakeTax(amountToTake) > moneyAmount || amountToTake <= 0) {
            return;
        }
        moneyAmount -= amountToTake + getTakeTax(amountToTake);
    }

    protected void setTakeTaxPercent(double percent) {
        this.takeTaxPercent = percent;
    }
    protected void setPutTaxPercent(double percent){
        this.putTaxPercent = percent;
    }

    private double getTakeTax(double moneyAmount) {
        return moneyAmount * (takeTaxPercent / 100);
    }

    private double getPutTax(double moneyAmount){
        return moneyAmount * (putTaxPercent / 100);
    }

}
