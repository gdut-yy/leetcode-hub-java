package p1907;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1907ATests extends AbstractOjTests {
    public CF1907ATests() {
        super("/p1907/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1907A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
