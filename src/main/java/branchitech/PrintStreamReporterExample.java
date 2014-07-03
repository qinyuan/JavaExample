package branchitech;

import com.branchitech.metrics.reporter.PrintStreamReporter;
import com.branchitech.metrics.reporter.PrintStreamReporterConfig;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.TimeMeter;

/**
 * Created by qinyuan on 14-7-2.
 */
public class PrintStreamReporterExample {

    private static MetricRegistry registry = new MetricRegistry();

    private static PrintStreamReporterConfig getConfig() {
        PrintStreamReporterConfig config = new PrintStreamReporterConfig();
        config.setRegistry(registry);
        config.setOut(System.out);
        return config;
    }

    private static void createMetrics() {
        TimeMeter meter = new TimeMeter();
        registry.register("testMeter", meter);
    }

    private static PrintStreamReporter getReporter() {
        PrintStreamReporter reporter = new PrintStreamReporter(getConfig());
        return reporter;
    }

    public static void main(String[] args) {
        createMetrics();
        PrintStreamReporter reporter = getReporter();
        reporter.report();
    }
}
