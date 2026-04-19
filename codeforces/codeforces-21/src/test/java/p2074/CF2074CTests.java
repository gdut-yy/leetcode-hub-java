package p2074;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2074CTests extends AbstractOjTests {
    public CF2074CTests() {
        super("/p2074/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2074C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}