package p1270;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1270BTests extends AbstractOjTests {
    public CF1270BTests() {
        super("/p1270/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1270B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}