package p1837;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1837CTests extends AbstractOjTests {
    public CF1837CTests() {
        super("/p1837/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1837C.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}