package p2048;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2048CTests extends AbstractOjTests {
    public CF2048CTests() {
        super("/p2048/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2048C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}