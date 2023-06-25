package p1837;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1837ATests extends AbstractOjTests {
    public CF1837ATests() {
        super("/p1837/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1837A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}