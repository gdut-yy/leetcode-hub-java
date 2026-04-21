package p1924;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1924ATests extends AbstractOjTests {
    public CF1924ATests() {
        super("/p1924/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1924A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}