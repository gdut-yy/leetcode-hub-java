package p1741;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1741BTests extends AbstractOjTests {
    public CF1741BTests() {
        super("/p1741/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1741B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
