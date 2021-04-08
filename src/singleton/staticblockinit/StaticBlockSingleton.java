package singleton.staticblockinit;

/**
 * eager init과 마찬가지로 클래스 로딩 단계에서 인스턴스를 생성하므로 메모리 낭비 될 수 있음.
 * Exception에 대핸 handling 제공
 *
 */

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    static {
        try{

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
