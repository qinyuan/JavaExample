package gmetric4j;

import info.ganglia.gmetric4j.gmetric.GMetric;

import java.util.Random;

public class MulticastExample {

    public static void main(String[] args) throws Exception {
        Random rnd = new Random();
        String host = "239.2.11.72";
        int port = 8649;
        int ttl = 1;
        GMetric gMetric = new GMetric(host, port, GMetric.UDPAddressingMode.MULTICAST, ttl);

        while(true) {
            gMetric.announce("gmetric4j_test", rnd.nextLong(), "gmetrics4j_test_group");
            Thread.sleep(5000);
        }
    }
}
