package p1156;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1156BTests extends AbstractOjTests {
    public CF1156BTests() {
        super("/p1156/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1156B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}