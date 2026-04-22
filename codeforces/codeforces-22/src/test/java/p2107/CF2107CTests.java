package p2107;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2107CTests extends AbstractOjTests {
    public CF2107CTests() {
        super("/p2107/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2107C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}