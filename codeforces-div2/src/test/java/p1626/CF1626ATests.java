package p1626;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1626ATests extends AbstractOjTests {
    public CF1626ATests() {
        super("/p1626/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1626A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
