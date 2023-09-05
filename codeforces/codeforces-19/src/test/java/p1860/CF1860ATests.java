package p1860;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1860ATests extends AbstractOjTests {
    public CF1860ATests() {
        super("/p1860/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1860A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}