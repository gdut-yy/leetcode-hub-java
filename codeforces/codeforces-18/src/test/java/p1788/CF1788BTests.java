package p1788;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1788BTests extends AbstractOjTests {
    public CF1788BTests() {
        super("/p1788/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1788B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}