package p1988;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1988CTests extends AbstractOjTests {
    public CF1988CTests() {
        super("/p1988/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1988C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
