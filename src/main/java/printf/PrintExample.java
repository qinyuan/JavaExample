package printf;

/**
 * Created by qinyuan on 14-7-7.
 */
public class PrintExample {

    public static void main(String[] args) {
        System.out.printf("True is %b\n", true);
        System.out.printf("False is %b\n", false);
        System.out.printf("This is double %.2f\n", Math.PI * 100000);
        System.out.printf("This is double %f\n", 2.11);
    }
}
