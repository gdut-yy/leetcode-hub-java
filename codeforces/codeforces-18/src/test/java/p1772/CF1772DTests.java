package p1772;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1772DTests extends AbstractOjTests {
    public CF1772DTests() {
        super("/p1772/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1772D.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}