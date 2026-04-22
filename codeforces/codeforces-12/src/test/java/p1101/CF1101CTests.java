package p1101;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1101CTests extends AbstractOjTests {
    public CF1101CTests() {
        super("/p1101/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1101C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}