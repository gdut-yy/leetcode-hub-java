package p1893;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1893DTests extends AbstractOjTests {
    public CF1893DTests() {
        super("/p1893/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1893D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}