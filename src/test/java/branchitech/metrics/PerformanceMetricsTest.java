package branchitech.metrics;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.branchitech.metrics.PerformanceMetrics;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PerformanceMetricsTest {

    @Autowired
    private MetricsBean metricsBean1;

    @Autowired
    private MetricsBean metricsBean2;
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        metricsBean1.performanceMetrics();
        metricsBean2.performanceMetrics();

        metricsBean1.createByDefault();
        metricsBean2.createByDefault();

        metricsBean1.methodByAbstractClass();
        metricsBean2.methodByAbstractClass();

        metricsBean1.methodFromAbstractClass();
        metricsBean2.methodFromAbstractClass();

        metricsBean1.methodFromInterface();
        metricsBean2.methodFromInterface();

        assertFalse(metricsBean1.getClass() == MetricsBean.class);
        assertTrue(metricsBean1.getClass() == metricsBean2.getClass());

        final Map<String, PerformanceMetrics> metrics = PerformanceMetrics
                .metrics();

        assertTrue(metrics.size() == 5);

        for (final PerformanceMetrics metric : metrics.values()) {
            assertTrue(metric.getAllCount() == 2);
        }
    }
}
