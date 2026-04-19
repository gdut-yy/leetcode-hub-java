package p2037;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2037CTests extends AbstractOjTests {
    public CF2037CTests() {
        super("/p2037/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2037C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}