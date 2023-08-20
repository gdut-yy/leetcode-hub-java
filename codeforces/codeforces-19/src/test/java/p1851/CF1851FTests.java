package p1851;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1851FTests extends AbstractOjTests {
    public CF1851FTests() {
        super("/p1851/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1851F.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}