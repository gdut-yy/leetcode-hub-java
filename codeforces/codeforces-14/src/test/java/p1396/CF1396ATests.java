package p1396;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1396ATests extends AbstractOjTests {
    public CF1396ATests() {
        super("/p1396/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1396A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}