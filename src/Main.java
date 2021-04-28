import decorator.beverage.Americano;
import decorator.beverage.Beverage;
import decorator.beverage.Cream;
import decorator.beverage.Shot;
import decorator.coffee.Base;
import decorator.coffee.Espresso;
import decorator.coffee.IBeverage;
import decorator.coffee.Milk;
import decorator.audi.*;
import proxy.proxy1.Proxy;
import proxy.proxy1.RealSubject;
import proxy.proxy1.Subject;
import proxy.proxy2.CreditCard;
import proxy.proxy2.Store;
import proxy.proxy2.VIPCard;
import proxy.proxy3.AopBrowser;
import proxy.proxy3.Browser;
import proxy.proxy3.BrowserProxy;
import proxy.proxy3.IBrowser;
import singleton.eagerinit.EagerInitSingleton;
import singleton.enumsingleton.EnumSIngleton;


import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String argc[]) {
//        proxyTest();
//        decoratorTest();
//        proxyTest2();
        //proxyTest3();
//        decoratorTest2();
//        singletonTest();
        decorator();
    }

    static void decorator() {
        Beverage beverage = new Americano();
        beverage = new Shot(beverage);
        beverage = new Shot(beverage);
        beverage = new Cream(beverage);

        System.out.println("메뉴 : " + beverage.getDescription());
        System.out.println("가격 : " + beverage.cost());
    }

    static void singletonTest() {
        EagerInitSingleton eagerInitSingleton = EagerInitSingleton.getInstance();
        System.out.println("eagerInitSingleton = " + eagerInitSingleton);

        EnumSIngleton.doSomething();
    }

    static void decoratorTest2() {
        ICar audi = new Audi(1000);
        audi.showPrice();

        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();

    }

    static void proxyTest3() {
        IBrowser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();

        browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();


        browser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });

        browser.show();
        System.out.println("loading time : " + end.get());
        browser.show();
        System.out.println("loading time : " + end.get());
    }

    static void proxyTest2() {
        Store store = new Store(new CreditCard());
        store.buySomething(100);
        store.buySomething(150);
        store.buySomething(50);
        store = new Store(new VIPCard());
        store.buySomething(1000000);
        store.buySomething(101);
        store.buySomething(10);
    }

    static void decoratorTest() {
        Scanner sc = new Scanner(System.in);
        IBeverage beverage = new Base();

        while (true) {
            System.out.println("현재 음료 가격 : " + beverage.getTotalPrice());
            System.out.println("선택 -> 1:샷추가  2:우유 추가  0: 종료");
            switch (sc.nextInt()) {
                case 0:
                    return;
                case 1:
                    beverage = new Espresso(beverage);
                    break;
                case 2:
                    beverage = new Milk(beverage);
                    break;

            }
        }

    }

    static void proxyTest() {
        Subject subject = new Proxy(new RealSubject());
        subject.action1();
        subject.action2();
    }
}
