package p1761;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1761ETests extends AbstractOjTests {
    public CF1761ETests() {
        super("/p1761/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1761E.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}