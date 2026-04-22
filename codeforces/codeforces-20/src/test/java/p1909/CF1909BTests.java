package p1909;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1909BTests extends AbstractOjTests {
    public CF1909BTests() {
        super("/p1909/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1909B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}