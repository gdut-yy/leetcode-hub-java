package p1276;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1276ATests extends AbstractOjTests {
    public CF1276ATests() {
        super("/p1276/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1276A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1276A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}