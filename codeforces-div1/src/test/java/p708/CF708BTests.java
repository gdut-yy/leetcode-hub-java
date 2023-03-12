package p708;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF708BTests extends AbstractOjTests {
    public CF708BTests() {
        super("/p708/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF708B.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF708B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}