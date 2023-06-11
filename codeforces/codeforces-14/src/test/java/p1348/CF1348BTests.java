package p1348;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1348BTests extends AbstractOjTests {
    public CF1348BTests() {
        super("/p1348/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1348B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}