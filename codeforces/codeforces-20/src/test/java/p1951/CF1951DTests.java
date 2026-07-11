package p1951;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1951DTests extends AbstractOjTests {
    public CF1951DTests() {
        super("/p1951/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1951D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
