package p2134;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2134BTests extends AbstractOjTests {
    public CF2134BTests() {
        super("/p2134/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2134B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}