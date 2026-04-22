package p1781;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1781CTests extends AbstractOjTests {
    public CF1781CTests() {
        super("/p1781/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1781C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}