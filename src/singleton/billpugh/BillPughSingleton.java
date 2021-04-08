package singleton.billpugh;

/**
 * static inner class 사용.
 * out class가 로드 되어도 사용하지 않는다면 inner class가 메모리를 점유할 일이 없음.
 * 또한 inner class 로딩 단계에서 인스턴스를 생성하므로 쓰레드 세이프 함.
 *
 * lazy holder 라고 불림
 */

public class BillPughSingleton {

    private BillPughSingleton() {};

    private static class SingletonHelper {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.instance;
    }
}
