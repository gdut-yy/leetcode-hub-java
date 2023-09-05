package p1862;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1862BTests extends AbstractOjTests {
    public CF1862BTests() {
        super("/p1862/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1862B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}