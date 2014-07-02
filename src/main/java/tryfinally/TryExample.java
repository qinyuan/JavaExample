package tryfinally;

/**
 * Created by qinyuan on 14-6-24.
 */
public class TryExample {

    public static void main(String[] args) {
        try {
            System.out.println("in try");
            throw new RuntimeException("Hello");
        } finally {
            System.out.println("in finally");
        }
    }
}
