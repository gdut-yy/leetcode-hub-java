package p827;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF827BTests extends AbstractOjTests {
    public CF827BTests() {
        super("/p827/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF827B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF827B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}