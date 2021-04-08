package singleton.lazyinit;

/**
 * eager init과 static block의 이슈였던 메모리 문제는 해결함
 * 하지만 멀티 쓰레드 환경에서 인스턴스를 여러번 생성할 수 있는 가능성이 있음. 쓰레드 세이프하지 않음.
 *
 */
public class LazyInitSingleton {

    private static LazyInitSingleton instance;

    private LazyInitSingleton(){};

    public static LazyInitSingleton getInstance() {
        if(instance == null) {
            instance = new LazyInitSingleton();
        }

        return instance;
    }
}
