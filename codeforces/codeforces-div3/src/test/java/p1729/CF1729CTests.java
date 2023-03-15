package p1729;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1729CTests extends AbstractOjTests {
    public CF1729CTests() {
        super("/p1729/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1729C.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
