package p1901;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1901CTests extends AbstractOjTests {
    public CF1901CTests() {
        super("/p1901/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1901C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}