package p1932;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1932DTests extends AbstractOjTests {
    public CF1932DTests() {
        super("/p1932/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1932D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}