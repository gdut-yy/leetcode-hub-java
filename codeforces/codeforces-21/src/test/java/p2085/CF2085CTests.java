package p2085;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2085CTests extends AbstractOjTests {
    public CF2085CTests() {
        super("/p2085/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2085C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
