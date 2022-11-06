package p1754;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1754BTests extends AbstractOjTests {
    public CF1754BTests() {
        super("/p1754/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1754B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
