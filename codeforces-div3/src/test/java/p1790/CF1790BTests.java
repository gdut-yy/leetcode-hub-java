package p1790;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1790BTests extends AbstractOjTests {
    public CF1790BTests() {
        super("/p1790/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1790B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
