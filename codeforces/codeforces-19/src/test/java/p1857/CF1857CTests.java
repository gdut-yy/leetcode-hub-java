package p1857;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1857CTests extends AbstractOjTests {
    public CF1857CTests() {
        super("/p1857/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1857C.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}