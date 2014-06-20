package springjunit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SpringJUnitTest {

    @Test
    public void testAddOpinion1() {
        assertTrue(true);
    }

    @Test
    public void testAddOpinion2() {
        assertTrue(true);
    }
}
