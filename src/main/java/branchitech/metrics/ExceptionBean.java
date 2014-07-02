package branchitech.metrics;

import com.branchitech.metrics.annotation.PerformanceMetric;

@PerformanceMetric()
public class ExceptionBean extends AbstractMetricsBean {
    /**
     * 缺省的构造方法.
     */
    public ExceptionBean() {
    }

    /**
     * 测试{@link com.branchitech.metrics.annotation.PerformanceMetric}
     */
    @PerformanceMetric()
    public void performanceMetrics() {

    }

    public void createByDefault() {

    }

    @Override
    public void methodFromAbstractClass() {
    }

    @SuppressWarnings("unused")
    private void ignoreMetric() {

    }
}