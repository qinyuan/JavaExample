package branchitech.metrics;

import com.branchitech.metrics.annotation.InheritedMetricDefine;
import com.branchitech.metrics.annotation.PerformanceMetric;
import com.branchitech.metrics.annotation.PerformanceMetricScan;

@InheritedMetricDefine
@PerformanceMetricScan(includeClasses = {AbstractMetricsBean.class})
public abstract class AbstractMetricsBean implements IMetricsBean {

    @Override
    public void methodFromInterface() {
    }

    @PerformanceMetric
    public void methodByAbstractClass() {
    }

    ;

    @PerformanceMetric
    @SuppressWarnings("unused")
    public abstract void methodFromAbstractClass();
}