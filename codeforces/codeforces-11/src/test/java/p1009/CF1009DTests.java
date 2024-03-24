package p1009;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1009DTests extends AbstractOjTests {
    public CF1009DTests() {
        super("/p1009/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1009D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1009D.main(null);
        super.doAssertion(OUTPUT2);
    }
}