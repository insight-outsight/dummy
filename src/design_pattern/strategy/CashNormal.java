package design_pattern.strategy;
public class CashNormal extends CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }

}