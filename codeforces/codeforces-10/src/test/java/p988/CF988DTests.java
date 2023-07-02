package p988;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF988DTests extends AbstractOjTests {
    public CF988DTests() {
        super("/p988/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF988D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF988D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}