package p2057;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2057CTests extends AbstractOjTests {
    public CF2057CTests() {
        super("/p2057/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2057C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}