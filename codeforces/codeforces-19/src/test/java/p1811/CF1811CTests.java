package p1811;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1811CTests extends AbstractOjTests {
    public CF1811CTests() {
        super("/p1811/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1811C.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}