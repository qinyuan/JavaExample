package reflection.getsupper;

public class Sub extends Parent<StringBuilder> {

    public static void main(String[] args) {
        new Sub().test();
        new Sub2().test();
    }

    public static class Sub2 extends Parent<StringBuilder[]> {
    }
}
