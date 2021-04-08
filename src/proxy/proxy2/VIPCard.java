package proxy.proxy2;

public class VIPCard implements Payment {

    Payment card = new CreditCard();

    @Override
    public void pay(int amount) {
        if (amount > 10000)
            System.out.println(amount + " VIP 결제");
        else
            card.pay(amount);
    }
}
