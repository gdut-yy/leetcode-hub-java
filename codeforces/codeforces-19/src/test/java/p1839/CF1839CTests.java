package p1839;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1839CTests extends AbstractOjTests {
    public CF1839CTests() {
        super("/p1839/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1839C.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}