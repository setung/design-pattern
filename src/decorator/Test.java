package decorator;

public class Test {
    public static void main(String argc[]) {
        IBeverage beverage = new Espresso();
        System.out.println("beverage = " + beverage);
        beverage = new Cream(beverage);
        System.out.println("beverage = " + beverage);
        beverage = new Shot(beverage);
        System.out.println("beverage = " + beverage);
    }

}

interface IBeverage {
    int cost();

}

class Espresso implements IBeverage {
    String name = "에스프레소";

    @Override
    public int cost() {
        return 1000;
    }

    public String desc() {
       return name;
    }

    @Override
    public String toString() {
        return "Espresso{" +
                "name='" + desc() + '\'' +
                '}' +
                " " +
                cost();
    }
}

class Decorator extends Espresso {

    @Override
    public int cost() {
        return 0;
    }

}

class Shot extends Espresso {

    IBeverage beverage;

    public Shot(IBeverage beverage) {
        this.beverage = beverage;
        name = beverage + " 샷 추가 ";
    }

    @Override
    public int cost() {
        return beverage.cost() + 400;
    }

}

class Cream extends Espresso {

    IBeverage beverage;

    public Cream(IBeverage beverage) {
        this.beverage = beverage;
        name = beverage + " 크림 추가 ";
    }

    @Override
    public int cost() {
        return beverage.cost() + 500;
    }

}