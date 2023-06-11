package p1722;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1722GTests extends AbstractOjTests {
    public CF1722GTests() {
        super("/p1722/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1722G.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
