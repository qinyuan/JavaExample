package parametered;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AddTest3 {

    private int input1;
    private int input2;
    private int expected;

    @Parameters
    public static Collection prepareData() {
        Object[][] object = {{-1, -2, -3}, {0, 2, 2}, {-1, 1, 0}, {1, 2, 3}};
        return Arrays.asList(object);
    }

    public AddTest3(int input1, int input2, int expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = expected;
    }

    @Test
    public void testAdd() {
        System.out.println(input1 + " " + input2 + " " + expected);
    }
}
