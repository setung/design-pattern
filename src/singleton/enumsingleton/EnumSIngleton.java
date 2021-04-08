package singleton.enumsingleton;

/**
    다른 방식의 싱글톤은 Reflection을 통해 싱글톤을 파괴할 수 있음.
    enum으로 하며 안전한가 봄.
    메모리 낭비가 될 수 있음.
 */

public enum EnumSIngleton {
    INSTANCE;

    public static void doSomething() {
        System.out.println("enum singleton");
    }
}
