package p1983;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1983CTests extends AbstractOjTests {
    public CF1983CTests() {
        super("/p1983/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1983C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}