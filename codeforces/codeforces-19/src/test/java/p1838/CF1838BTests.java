package p1838;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1838BTests extends AbstractOjTests {
    public CF1838BTests() {
        super("/p1838/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1838B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}