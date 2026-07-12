package p1864;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1864CTests extends AbstractOjTests {
    public CF1864CTests() {
        super("/p1864/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1864C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
