package p1754;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1754C2Tests extends AbstractOjTests {
    public CF1754C2Tests() {
        super("/p1754/C2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1754C2.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}