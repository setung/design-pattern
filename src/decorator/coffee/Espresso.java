package decorator.coffee;

public class Espresso extends AbstAdding{

    static protected int espressoCount = 0;

    public Espresso(IBeverage base) {
        super(base);
    }

    @Override
    public int getTotalPrice() {
        return super.getTotalPrice() + getAddPrice();
    }

    private int getAddPrice() {
        return (espressoCount++ > 1) ? 70 : 100;
    }
}
