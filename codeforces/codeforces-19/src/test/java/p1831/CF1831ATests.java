package p1831;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1831ATests extends AbstractOjTests {
    public CF1831ATests() {
        super("/p1831/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1831A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}