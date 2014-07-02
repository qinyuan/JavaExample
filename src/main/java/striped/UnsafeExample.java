package striped;

/*
import sun.misc.Unsafe;

public class UnsafeExample {

    private static final Unsafe UNSAFE;
    private static final long valueOffset;
    private int value = 10;

    static {
        try {
            UNSAFE = getUnsafe();
            Class<?> ak = UnsafeExample.class;
            valueOffset = UNSAFE.objectFieldOffset
                    (ak.getDeclaredField("value"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static sun.misc.Unsafe getUnsafe() {
        try {
            return sun.misc.Unsafe.getUnsafe();
        } catch (SecurityException ignored) {
        }
        try {
            return java.security.AccessController.doPrivileged
                    (new java.security.PrivilegedExceptionAction<sun.misc.Unsafe>() {
                        public sun.misc.Unsafe run() throws Exception {
                            Class<sun.misc.Unsafe> k = sun.misc.Unsafe.class;
                            for (java.lang.reflect.Field f : k.getDeclaredFields()) {
                                f.setAccessible(true);
                                Object x = f.get(null);
                                if (k.isInstance(x))
                                    return k.cast(x);
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
        } catch (java.security.PrivilegedActionException e) {
            throw new RuntimeException("Could not initialize intrinsics",
                    e.getCause());
        }
    }

    public void test() {
        int exepect = this.value;
        int newValue = 240;
        boolean result = UNSAFE.compareAndSwapLong(this, valueOffset, exepect, newValue);
        System.out.println("Update result: " + result);
        System.out.println("After update: " + this.value);
    }

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void main(String[] args) throws Exception {
        new UnsafeExample().test();
    }
}
*/
