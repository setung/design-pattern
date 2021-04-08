package singleton.eagerinit;

/**
    클래스의 인스턴스를 클래스 로딩단계에서 생성하는 방법
    해당 인스턴스를 사용하지 않더라도 메모리에 공간 차지 하므로 낭비가 될 수 있음.
    인스턴스 생성 시 Exception에 대한 handling 제공 안함.
    쓰레드 세이프 할 듯(?)
 **/

public class EagerInitSingleton {

    static{
        System.out.println("EagerInitSingleton 로드");
    }

    private static EagerInitSingleton instance = new EagerInitSingleton();

    private EagerInitSingleton(){
        System.out.println("EagerInitSingleton instance 생성");
    };

    public static EagerInitSingleton getInstance(){
        return instance;
    }
}
