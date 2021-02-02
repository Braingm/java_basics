public class IndividualBusinessman extends Client {

    @Override
    public void put(double amountToPut) {
        if (amountToPut <= 1000) {
            setPutTaxPercent(1);
        }
        if (amountToPut > 1000) {
            setPutTaxPercent(0.5);
        }
        super.put(amountToPut);
    }

}
