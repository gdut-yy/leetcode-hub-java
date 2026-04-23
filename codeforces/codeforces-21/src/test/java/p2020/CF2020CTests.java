package p2020;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2020CTests extends AbstractOjTests {
    public CF2020CTests() {
        super("/p2020/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2020C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}