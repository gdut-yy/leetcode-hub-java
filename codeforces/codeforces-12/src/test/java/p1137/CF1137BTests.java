package p1137;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1137BTests extends AbstractOjTests {
    public CF1137BTests() {
        super("/p1137/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1137B.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1137B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF1137B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT3);
    }
}