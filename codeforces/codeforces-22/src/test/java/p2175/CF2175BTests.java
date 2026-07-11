package p2175;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2175BTests extends AbstractOjTests {
    public CF2175BTests() {
        super("/p2175/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2175B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
