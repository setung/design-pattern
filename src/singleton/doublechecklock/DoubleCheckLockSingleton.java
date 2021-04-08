package singleton.doublechecklock;

/**
    메소드 단위 synchronized를 사용 하는 것보다 개선됨.

    하지만 완벽하게 쓰레드 세이프 하지 않음
    메모리 가시성 문제로 volatile를 도배 해야 되나봄.
 */

public class DoubleCheckLockSingleton {
    private static DoubleCheckLockSingleton instance;

    private DoubleCheckLockSingleton(){};

    public static DoubleCheckLockSingleton getInstance() {
        if(instance ==null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance==null) {
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }

        return instance;
    }
}
