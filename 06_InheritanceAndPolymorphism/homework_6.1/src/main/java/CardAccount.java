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
}
