package p1032;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1032CTests extends AbstractOjTests {
    public CF1032CTests() {
        super("/p1032/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1032C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1032C.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF1032C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT3);
    }
}