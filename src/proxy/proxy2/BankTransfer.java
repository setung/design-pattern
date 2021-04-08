package proxy.proxy2;

public class BankTransfer implements Payment{

    @Override
    public void pay(int amount) {
        System.out.println(amount + " 계좌 이체");
    }
}
