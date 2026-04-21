package p1798;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1798DTests extends AbstractOjTests {
    public CF1798DTests() {
        super("/p1798/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1798D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}