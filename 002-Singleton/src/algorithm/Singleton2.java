package algorithm;

/**
 * 饱汉模式
 */
public class Singleton2 {

    private Singleton2() {

    }

    private static volatile Singleton2 instance = null;

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
