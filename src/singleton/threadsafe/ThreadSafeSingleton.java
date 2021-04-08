package singleton.threadsafe;

/**
 * synchronized를 사용해 쓰레드 세이프하게 만듬
 * 하지만 오버헤드 성능 이슈가 생길 수 있음.
 */

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){};

    public static synchronized ThreadSafeSingleton getInstance() {
        if(instance==null)
            instance = new ThreadSafeSingleton();

        return instance;
    }
}
