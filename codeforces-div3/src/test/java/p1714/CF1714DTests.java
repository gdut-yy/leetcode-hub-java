package p1714;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1714DTests extends AbstractOjTests {
    public CF1714DTests() {
        super("/p1714/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1714D.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
