import java.math.BigDecimal;

public class CardAccount extends BankAccount {

    @Override
    public void take(double amountToTake) {
        double penny = amountToTake * 0.01;
        if (amountToTake <= 0){
            return;
        }
        if (amountToTake + penny > moneyAmount.doubleValue()){
            return;
        }

         moneyAmount = moneyAmount.subtract(BigDecimal.valueOf(amountToTake + penny));
    }

    @Override
    public boolean send(BankAccount receiver, double amount) {
        double penny = amount * 0.01;
        if (amount + penny > moneyAmount.doubleValue()){
            return false;
        }

        this.take(amount);
        receiver.put(amount);
        return true;
    }

}
