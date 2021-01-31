import java.math.BigDecimal;

public class BankAccount {
    protected BigDecimal moneyAmount = new BigDecimal(0);

    public double getAmount() {
        return moneyAmount.doubleValue();
    }

    protected void put(double amountToPut) {
        if (amountToPut <= 0) {
            return;
        }

        moneyAmount = moneyAmount.add(BigDecimal.valueOf(amountToPut));
    }

    protected void take(double amountToTake) {
        if (amountToTake <= 0) {
            return;
        }
        if (amountToTake > getAmount()) {
            return;
        }

        moneyAmount = moneyAmount.subtract(BigDecimal.valueOf(amountToTake));
    }

    protected void take(double amountToTake, double taxPercent) {
      double tax = amountToTake * taxPercent;
        if (amountToTake <= 0) {
          return;
        }
        if (amountToTake + tax > getAmount()){
          return;
        }

        moneyAmount = moneyAmount.subtract(BigDecimal.valueOf(amountToTake + tax));
    }

    protected boolean send(BankAccount receiver, double amount) {
        if (amount > getAmount()) {
            return false;
        }

        this.take(amount);
        receiver.put(amount);
        return true;
    }
}
