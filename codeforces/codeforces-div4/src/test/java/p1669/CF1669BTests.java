package p1669;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1669BTests extends AbstractOjTests {
    public CF1669BTests() {
        super("/p1669/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1669B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
