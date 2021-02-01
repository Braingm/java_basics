
public class LegalPerson extends Client {

    @Override
    public void take(double amountToTake) {
        double tax = amountToTake * 0.01;
        if (amountToTake + tax  > moneyAmount || amountToTake <= 0){
            return;
        }
        moneyAmount -= amountToTake + tax;
    }

}
