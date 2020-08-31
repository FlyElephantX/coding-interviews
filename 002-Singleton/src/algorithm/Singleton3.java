package algorithm;

public class Singleton3 {

    private Singleton3() {

    }

    private static class Holder {
        private static Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return Holder.instance;
    }
}
