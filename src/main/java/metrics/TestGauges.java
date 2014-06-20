package metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestGauges {
	/**
	 * 实例化一个registry，最核心的一个模块，相当于一个应用程序的metrics系统的容器，维护一个Map
	 */
	private static final MetricRegistry metrics = new MetricRegistry();
	private static List<String> list = new LinkedList<String>();

	/**
	 * 在控制台上打印输出
	 */
	private static ConsoleReporter reporter = ConsoleReporter.forRegistry(
			metrics).build();

	public static void main(String[] args) throws InterruptedException {
		reporter.start(3, TimeUnit.SECONDS);

		// 实例化一个Gauge
		Gauge<Integer> gauge = new Gauge<Integer>() {
			public Integer getValue() {
				return list.size();
			}
		};

		// 注册到容器中
		metrics.register(
				MetricRegistry.name(TestGauges.class, "pending-job", "size"),
				gauge);

		// 模拟数据
		for (int i = 0; i < 20; i++) {
			list.add("a");
			Thread.sleep(1000);
		}
	}
}