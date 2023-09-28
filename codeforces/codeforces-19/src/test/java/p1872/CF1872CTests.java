package p1872;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1872CTests extends AbstractOjTests {
    public CF1872CTests() {
        super("/p1872/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1872C.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}