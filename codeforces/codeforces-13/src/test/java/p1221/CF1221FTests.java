package p1221;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1221FTests extends AbstractOjTests {
    public CF1221FTests() {
        super("/p1221/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1221F.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1221F.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}
