package branchitech.metrics.bean;

import com.branchitech.metrics.annotation.PerformanceMetric;

@PerformanceMetric()
public class MetricsBean extends AbstractMetricsBean {
    /**
     * 缺省的构造方法.
     */
    public MetricsBean() {
    }

    /**
     * 测试{@link PerformanceMetric}
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