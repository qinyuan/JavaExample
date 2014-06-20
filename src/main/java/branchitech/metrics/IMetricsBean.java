package branchitech.metrics;

import com.branchitech.metrics.annotation.PerformanceMetric;

public interface IMetricsBean {
    @PerformanceMetric
    void methodFromInterface();
}