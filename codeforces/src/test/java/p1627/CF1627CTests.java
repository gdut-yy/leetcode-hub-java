package p1627;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1627CTests extends AbstractOjTests {
    public CF1627CTests() {
        super("/p1627/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1627C.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
