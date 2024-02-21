package p960;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF960CTests extends AbstractOjTests {
    public CF960CTests() {
        super("/p960/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF960C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF960C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}