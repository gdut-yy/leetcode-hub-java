package p1579;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1579BTests extends AbstractOjTests {
    public CF1579BTests() {
        super("/p1579/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1579B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
