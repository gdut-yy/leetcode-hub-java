package p1793;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1793BTests extends AbstractOjTests {
    public CF1793BTests() {
        super("/p1793/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1793B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
