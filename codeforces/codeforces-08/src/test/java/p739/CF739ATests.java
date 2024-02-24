package p739;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF739ATests extends AbstractOjTests {
    public CF739ATests() {
        super("/p739/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF739A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF739A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}