package p1148;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1148DTests extends AbstractOjTests {
    public CF1148DTests() {
        super("/p1148/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1148D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1148D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}