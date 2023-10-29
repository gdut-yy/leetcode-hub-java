package p1861;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1861ATests extends AbstractOjTests {
    public CF1861ATests() {
        super("/p1861/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1861A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}