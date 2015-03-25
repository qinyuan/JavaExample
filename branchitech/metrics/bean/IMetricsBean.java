package branchitech.metrics.bean;

import com.branchitech.metrics.annotation.PerformanceMetric;

public interface IMetricsBean {
    @PerformanceMetric
    @SuppressWarnings("unused")
    void methodFromInterface();
}