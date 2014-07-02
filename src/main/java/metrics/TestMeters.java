package metrics;

import static com.codahale.metrics.MetricRegistry.name;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

/**
 * Meteter is used to measures the rate at which a set of event occur
 * 
 * @author qinyuan
 * 
 */
public class TestMeters {

	private static MetricRegistry metricRegistry;

	private static Meter meters;

	private static void printMeters() {
		System.out.println("getCount(): " + meters.getCount());
		System.out.println("getMeanRate(): " + meters.getMeanRate());
		System.out.println("getOneMinuteRate(): " + meters.getOneMinuteRate());
		System.out
				.println("getFiveMinuteRate(): " + meters.getFiveMinuteRate());
		System.out.println("getFifteenMinuteRate(): "
				+ meters.getFifteenMinuteRate());
	}


    public static void executeTest(int firstPeriod, int firstPeriodRate, int secondPeriod) throws Exception {
        /*
         * 初始化meter指标
         */
        metricRegistry =new MetricRegistry();
        meters = metricRegistry.meter(name(TestMeters.class,"meters"));

        final int ONE_MINUTE = 1000;
        System.out.println("========= start Test ============");
		/*
		 * 每分钟执行firstPeriodRate次mark()方法，持续firstPeriod秒
		 */
		for (int i = 0; i < firstPeriod ; i++) {
			meters.mark(firstPeriodRate);
			Thread.sleep(ONE_MINUTE);
		}
        System.out.println("前面" + firstPeriod + "秒钟里，每秒钟执行" + firstPeriodRate + "次mark()");
		printMeters();

        System.out.println("---------------------------------");

		/*
		 * 不执行mark()，持续300秒（五分钟）
		 */
		for (int i = 0; i < secondPeriod; i++) {
			Thread.sleep(ONE_MINUTE);
		}
        System.out.println("后面" + secondPeriod + "秒钟里不执行mark()");
		printMeters();

        System.out.println("========== end Test =============");
    }

	public static void main(String[] args) throws Exception {
        executeTest(30, 1, 60);
        executeTest(30, 100, 60);
        executeTest(5, 1, 120);
        executeTest(60, 1, 300);
        executeTest(60, 100, 300);
	}
}
