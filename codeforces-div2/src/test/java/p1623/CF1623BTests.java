package p1623;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1623BTests extends AbstractOjTests {
    public CF1623BTests() {
        super("/p1623/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1623B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
