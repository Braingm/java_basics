
public class IndividualBusinessman extends Client {

    @Override
    public void put(double amountToPut) {
        double tax;
        if (amountToPut <= 0){
            return;
        }
        if (amountToPut < 1000){
            tax = amountToPut * 0.01;
            moneyAmount += amountToPut - tax;
        }
        if (amountToPut > 1000){
            tax = amountToPut * 0.005;
            moneyAmount += amountToPut - tax;
        }
    }

}
