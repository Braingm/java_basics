
public class LegalPerson extends Client {

    @Override
    public void take(double amountToTake) {
        setTakeTaxPercent(1);
        super.take(amountToTake);
    }

}
