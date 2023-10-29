package p1878;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1878BTests extends AbstractOjTests {
    public CF1878BTests() {
        super("/p1878/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1878B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}