package branchitech.report;

import com.branchitech.metrics.reporter.PrintStreamReporter;
import com.branchitech.metrics.reporter.PrintStreamReporterConfig;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.TimeMeter;

/**
 * This is an PrintStreamReporterExample.
 * We create a TimeMeter metrics, call it several times, then report it
 */
public class PrintStreamReporterExample {

    private static MetricRegistry registry = new MetricRegistry();

    private static void createMetrics() {
        TimeMeter meter = new TimeMeter();
        for (int i = 0; i < 50; i++) {
            meter.mark();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        registry.register("testMeter", meter);
    }

    private static PrintStreamReporter getReporter() {
        PrintStreamReporterConfig config = new PrintStreamReporterConfig();
        config.setRegistry(registry);
        config.setOut(System.out);
        return new PrintStreamReporter(config);
    }

    public static void main(String[] args) {
        createMetrics();
        PrintStreamReporter reporter = getReporter();
        reporter.report();
    }
}
