public class IndividualBusinessman extends Client {

    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            super.put(amountToPut,1);
        }
        if (amountToPut >= 1000) {
            super.put(amountToPut,0.5);
        }
    }

}
