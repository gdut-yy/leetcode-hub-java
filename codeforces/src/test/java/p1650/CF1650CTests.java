package p1650;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1650CTests extends AbstractOjTests {
    public CF1650CTests() {
        super("/p1650/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1650C.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
