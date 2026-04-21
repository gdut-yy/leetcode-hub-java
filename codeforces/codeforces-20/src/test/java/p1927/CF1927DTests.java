package p1927;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1927DTests extends AbstractOjTests {
    public CF1927DTests() {
        super("/p1927/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1927D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}