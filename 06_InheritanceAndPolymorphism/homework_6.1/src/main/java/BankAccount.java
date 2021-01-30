import java.math.BigDecimal;

public class BankAccount {
  BigDecimal moneyAmount = new BigDecimal(0);

  public double getAmount() {
    return moneyAmount.doubleValue();
  }

  public void put(double amountToPut) {
    if (amountToPut <= 0){
      return;
    }

    moneyAmount = moneyAmount.add(BigDecimal.valueOf(amountToPut));
  }

  public void take(double amountToTake) {
    if (amountToTake <= 0){
      return;
    }
    if (amountToTake > moneyAmount.doubleValue()){
      return;
    }

    moneyAmount = moneyAmount.subtract(BigDecimal.valueOf(amountToTake));
  }

  public boolean send(BankAccount receiver, double amount){
    if (amount > moneyAmount.doubleValue()){
      return false;
    }

    this.take(amount);
    receiver.put(amount);
    return true;
  }
}
