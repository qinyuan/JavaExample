package metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.*;

/**
 * Meteter if used to measures the rate at which a set of event occur
 * 
 * @author qinyuan
 * 
 */
public class TestMeters {

	private static final MetricRegistry metrics = new MetricRegistry();
	private static ConsoleReporter reporter = ConsoleReporter.forRegistry(
			metrics).build();

	private static final Meter requests = metrics.meter(name(TestMeters.class,
			"request"));

	public static void handleRequest() {
		requests.mark();
	}

	public static void main(String[] args) throws InterruptedException {
		reporter.start(3, TimeUnit.SECONDS);
		for (int i = 0; i < 20; i++) {
			handleRequest();
			Thread.sleep(1000);
		}
	}
}