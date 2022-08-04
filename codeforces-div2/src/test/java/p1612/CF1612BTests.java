package p1612;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1612BTests extends AbstractOjTests {
    public CF1612BTests() {
        super("/p1612/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1612B.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
