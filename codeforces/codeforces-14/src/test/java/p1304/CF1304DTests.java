package p1304;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1304DTests extends AbstractOjTests {
    public CF1304DTests() {
        super("/p1304/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1304D.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}