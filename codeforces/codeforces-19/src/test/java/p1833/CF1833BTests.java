package p1833;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1833BTests extends AbstractOjTests {
    public CF1833BTests() {
        super("/p1833/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1833B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}