package p1612;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1612ATests extends AbstractOjTests {
    public CF1612ATests() {
        super("/p1612/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1612A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
