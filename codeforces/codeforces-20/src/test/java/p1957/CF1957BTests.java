package p1957;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1957BTests extends AbstractOjTests {
    public CF1957BTests() {
        super("/p1957/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1957B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
