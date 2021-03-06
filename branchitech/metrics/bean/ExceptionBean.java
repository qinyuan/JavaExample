package branchitech.metrics.bean;

import com.branchitech.metrics.annotation.PerformanceMetric;

import java.io.IOException;
import java.sql.SQLException;

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
    public void performanceMetrics() throws SQLException {
        throw new SQLException();
    }

    @PerformanceMetric()
    public void createByDefault() throws IOException {
        throw new IOException();
    }

    @Override
    public void methodFromAbstractClass() {
    }

    public void blockMethod() {
        try {
            Thread.sleep(1000000000000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private void ignoreMetric() {
    }
}