package p23;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF23CTests extends AbstractOjTests {
    public CF23CTests() {
        super("/p23/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF23C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}