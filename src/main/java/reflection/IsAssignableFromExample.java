package reflection;

/**
 * Created by qinyuan on 14-7-11.
 */
public class IsAssignableFromExample {

    public static void main(String[] args) {
        System.out.println("IParent is IParent: " + IParent.class.isAssignableFrom(IParent.class));
        System.out.println("Parent is IParent: " + IParent.class.isAssignableFrom(Parent.class));
        System.out.println("IParent is Parent: " + Parent.class.isAssignableFrom(IParent.class));
        System.out.println("Son is Parent: " + Parent.class.isAssignableFrom(Son.class));
        System.out.println("Son is IParent: " + IParent.class.isAssignableFrom(Son.class));
        System.out.println("Son is Object: " + Object.class.isAssignableFrom(Son.class));
    }

    private static interface IParent {
    }

    private static class Parent implements IParent {
    }

    private static class Son extends Parent {
    }
}
