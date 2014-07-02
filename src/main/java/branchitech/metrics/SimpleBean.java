package branchitech.metrics;

import com.branchitech.metrics.annotation.PerformanceMetric;

import java.io.IOException;
import java.sql.SQLException;

@SuppressWarnings("unused")
@PerformanceMetric()
public class SimpleBean {

    public SimpleBean() {
    }

    public void sqlExceptionMetric() throws SQLException {
        throw new SQLException();
    }

    public void ioExceptionMetric() throws IOException {
        throw new IOException();
    }

    public void normalMetric() {
    }
}