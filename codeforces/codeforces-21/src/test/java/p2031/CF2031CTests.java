package p2031;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2031CTests extends AbstractOjTests {
    public CF2031CTests() {
        super("/p2031/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2031C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
