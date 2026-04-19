package p911;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF911FTests extends AbstractOjTests {
    public CF911FTests() {
        super("/p911/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF911F.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF911F.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}