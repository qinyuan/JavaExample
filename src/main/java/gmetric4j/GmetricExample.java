package gmetric4j;

import info.ganglia.gmetric4j.gmetric.GMetric;

import java.util.Random;

/**
 * Created by qinyuan on 14-7-3.
 */
public class GmetricExample {

    public static void main(String[] args) throws Exception {
        final Random rnd = new Random();
        final String host = "239.2.11.72";
        final int port = 8649;
        final int ttl = 1;
        GMetric gMetric = new GMetric(host, port, GMetric.UDPAddressingMode.MULTICAST, ttl);

        while(true) {
            gMetric.announce("gmetric4j_test", rnd.nextLong(), "gmetrics4j_test_group");
            Thread.sleep(5000);
        }
    }
}
