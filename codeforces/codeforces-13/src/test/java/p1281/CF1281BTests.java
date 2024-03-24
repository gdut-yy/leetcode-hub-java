package p1281;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1281BTests extends AbstractOjTests {
    public CF1281BTests() {
        super("/p1281/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1281B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}