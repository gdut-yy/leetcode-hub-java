package p2122;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2122CTests extends AbstractOjTests {
    public CF2122CTests() {
        super("/p2122/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2122C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
