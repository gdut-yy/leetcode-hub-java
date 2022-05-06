package p1674;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1674ATests extends AbstractOjTests {
    public CF1674ATests() {
        super("/p1674/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1674A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
